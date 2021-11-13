package com.cinar.customerservice.view.controller;

import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.usecase.CreateCustomerUseCase;
import com.cinar.customerservice.core.usecase.FindCustomerUseCase;
import com.cinar.customerservice.core.usecase.io.CreateCustomerUseCaseInput;
import com.cinar.customerservice.core.usecase.io.FindCustomerUseCaseInput;
import com.cinar.customerservice.view.dto.CustomerDetailsDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

  private final FindCustomerUseCase findCustomerUseCase;
  private final CreateCustomerUseCase createCustomerUseCase;

  @GetMapping
  public ResponseEntity<CustomerDetailsDto> findCustomerDetails(
      @RequestParam String id) {

    final CustomerDetailsDomain customerDetails = findCustomerUseCase.run(
            new FindCustomerUseCaseInput(id))
        .getCustomerDetails();

    return ResponseEntity.ok(CustomerDetailsDto.fromCustomerDetailsDomain(customerDetails));
  }

  @PostMapping
  public ResponseEntity<CustomerDetailsDto> createCustomer(
      @RequestBody CustomerDetailsDto customerDetailsDto) {

    final CustomerDetailsDomain customerDetails = createCustomerUseCase.run(
            new CreateCustomerUseCaseInput(customerDetailsDto.getName(),
                customerDetailsDto.getCommercialName(), customerDetailsDto.getStoreNumber(),
                customerDetailsDto.getCustomerNumber(),
                customerDetailsDto.getAddress()))
        .getCustomerDetails();

    return ResponseEntity.ok(CustomerDetailsDto.fromCustomerDetailsDomain(customerDetails));
  }

}
