package com.cinar.customerservice.core.usecase;

import static com.cinar.customerservice.core.usecase.FindCustomerUseCase.CUSTOMER_NOT_FOUND;
import static com.cinar.customerservice.generator.CustomerDetailsGenerator.randomCustomerDetailsWithGeocode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.cinar.customerservice.base.exception.ValidationException;
import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.repository.CustomerDetailsDomainRepository;
import com.cinar.customerservice.core.usecase.io.FindCustomerUseCaseInput;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindCustomerUseCaseTest {


  private FindCustomerUseCase findCustomerUseCase;

  @Mock
  private CustomerDetailsDomainRepository customerDetailsDomainRepository;

  @BeforeEach
  public void init() {
    findCustomerUseCase = new FindCustomerUseCase(
        customerDetailsDomainRepository);
  }

  @Test
  public void execute_givenCustomerDetailsDomain_thenReturn() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    when(customerDetailsDomainRepository.findById(customerDetails.getId())).thenReturn(
        Optional.of(customerDetails));

    final CustomerDetailsDomain response = findCustomerUseCase.run(
        new FindCustomerUseCaseInput(customerDetails.getId())).getCustomerDetails();

    assertEquals(customerDetails, response);
  }

  @Test
  public void execute_givenCustomerDetailsDomain_whenCustomerNotFound_thenThrowException() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    when(customerDetailsDomainRepository.findById(customerDetails.getId())).thenReturn(
        Optional.empty());

    ValidationException exception = assertThrows(ValidationException.class,
        () -> findCustomerUseCase.run(
            new FindCustomerUseCaseInput(customerDetails.getId())));

    assertEquals(CUSTOMER_NOT_FOUND, exception.getMessage());
  }
}
