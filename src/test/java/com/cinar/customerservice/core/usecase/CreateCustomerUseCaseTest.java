package com.cinar.customerservice.core.usecase;

import static com.cinar.customerservice.generator.CustomerDetailsGenerator.randomCustomerDetailsWithGeocode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.cinar.customerservice.base.exception.ValidationException;
import com.cinar.customerservice.core.client.GetGeocodingClient;
import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.repository.CustomerDetailsDomainRepository;
import com.cinar.customerservice.core.usecase.io.CreateCustomerUseCaseInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateCustomerUseCaseTest {

  private static final String CUSTOMER_NOT_VALID = "Name, Commercial Name, Store Number, Customer Number or Address cannot be empty!";
  private CreateCustomerUseCase createCustomerUseCase;

  @Mock
  private CustomerDetailsDomainRepository customerDetailsDomainRepository;
  @Mock
  private GetGeocodingClient getGeocodingClient;

  @BeforeEach
  public void init() {
    createCustomerUseCase = new CreateCustomerUseCase(getGeocodingClient,
        customerDetailsDomainRepository);
  }

  @Test
  public void execute_givenCustomerDetailsDomain_thenReturn() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    when(customerDetailsDomainRepository.create(customerDetails)).thenReturn(customerDetails);
    when(getGeocodingClient.execute(customerDetails.getAddressDetails().getAddress())).thenReturn(
        customerDetails.getAddressDetails());

    final CustomerDetailsDomain response = createCustomerUseCase.run(
        new CreateCustomerUseCaseInput(customerDetails.getName(),
            customerDetails.getCommercialName(), customerDetails.getStoreNumber(),
            customerDetails.getCustomerNumber(),
            customerDetails.getAddressDetails().getAddress()
        )).getCustomerDetails();

    assertEquals(customerDetails, response);
  }

  @Test
  public void execute_givenCustomerDetailsDomain_whenNameIsNull_thenReturn() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    ValidationException exception = assertThrows(ValidationException.class,
        () -> createCustomerUseCase.run(
            new CreateCustomerUseCaseInput(null,
                customerDetails.getCommercialName(), customerDetails.getStoreNumber(),
                customerDetails.getCustomerNumber(),
                customerDetails.getAddressDetails().getAddress()
            )));

    assertEquals(CUSTOMER_NOT_VALID, exception.getMessage());
  }

  @Test
  public void execute_givenCustomerDetailsDomain_whenCommercialNameIsNull_thenReturn() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    ValidationException exception = assertThrows(ValidationException.class,
        () -> createCustomerUseCase.run(
            new CreateCustomerUseCaseInput(customerDetails.getName(),
                null, customerDetails.getStoreNumber(),
                customerDetails.getCustomerNumber(),
                customerDetails.getAddressDetails().getAddress()
            )));

    assertEquals(CUSTOMER_NOT_VALID, exception.getMessage());
  }

  @Test
  public void execute_givenCustomerDetailsDomain_whenStoreNumberIsNull_thenReturn() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    ValidationException exception = assertThrows(ValidationException.class,
        () -> createCustomerUseCase.run(
            new CreateCustomerUseCaseInput(customerDetails.getName(),
                customerDetails.getCommercialName(), null,
                customerDetails.getCustomerNumber(),
                customerDetails.getAddressDetails().getAddress()
            )));

    assertEquals(CUSTOMER_NOT_VALID, exception.getMessage());
  }

  @Test
  public void execute_givenCustomerDetailsDomain_whenCustomerNumberIsNull_thenReturn() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    ValidationException exception = assertThrows(ValidationException.class,
        () -> createCustomerUseCase.run(
            new CreateCustomerUseCaseInput(customerDetails.getName(),
                customerDetails.getCommercialName(), customerDetails.getStoreNumber(),
                null,
                customerDetails.getAddressDetails().getAddress()
            )));

    assertEquals(CUSTOMER_NOT_VALID, exception.getMessage());
  }

  @Test
  public void execute_givenCustomerDetailsDomain_whenAddressIsNull_thenReturn() {
    CustomerDetailsDomain customerDetails = randomCustomerDetailsWithGeocode().toCustomerDetailsDomain();

    ValidationException exception = assertThrows(ValidationException.class,
        () -> createCustomerUseCase.run(
            new CreateCustomerUseCaseInput(customerDetails.getName(),
                customerDetails.getCommercialName(), customerDetails.getStoreNumber(),
                customerDetails.getCustomerNumber(),
                null
            )));

    assertEquals(CUSTOMER_NOT_VALID, exception.getMessage());
  }
}
