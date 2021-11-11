package com.cinar.customerservice.core.usecase;

import com.cinar.customerservice.base.annotation.UseCaseService;
import com.cinar.customerservice.base.usecase.UseCase;
import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.repository.CustomerDetailsDomainRepository;
import com.cinar.customerservice.core.usecase.io.FindCustomerUseCaseInput;
import com.cinar.customerservice.core.usecase.io.FindCustomerUseCaseOutput;
import lombok.AllArgsConstructor;

@UseCaseService
@AllArgsConstructor
public class FindCustomerUseCase implements
    UseCase<FindCustomerUseCaseInput, FindCustomerUseCaseOutput> {

  private final CustomerDetailsDomainRepository customerDetailsDomainRepository;

  @Override
  public FindCustomerUseCaseOutput run(FindCustomerUseCaseInput input) {
    input.validate();

    final CustomerDetailsDomain customerDetails = customerDetailsDomainRepository.findById(
            input.getId())
        .orElseThrow();

    return new FindCustomerUseCaseOutput(customerDetails);
  }
}
