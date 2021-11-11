package com.cinar.customerservice.core.usecase;

import com.cinar.customerservice.base.annotation.UseCaseService;
import com.cinar.customerservice.base.usecase.UseCase;
import com.cinar.customerservice.core.client.GetGeocodingClient;
import com.cinar.customerservice.core.domain.AddressDetailsDomain;
import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.repository.CustomerDetailsDomainRepository;
import com.cinar.customerservice.core.usecase.io.CreateCustomerUseCaseInput;
import com.cinar.customerservice.core.usecase.io.CreateCustomerUseCaseOutput;
import lombok.AllArgsConstructor;

@UseCaseService
@AllArgsConstructor
public class CreateCustomerUseCase implements
    UseCase<CreateCustomerUseCaseInput, CreateCustomerUseCaseOutput> {

  private final GetGeocodingClient getGeocodingClient;
  private final CustomerDetailsDomainRepository customerDetailsDomainRepository;

  @Override
  public CreateCustomerUseCaseOutput run(CreateCustomerUseCaseInput input) {
    input.validate();

    final AddressDetailsDomain addressDetails = getGeocodingClient.execute(input.getAddress());
    final CustomerDetailsDomain customerDetails = customerDetailsDomainRepository.create(
        new CustomerDetailsDomain(input.getName(), input.getCommercialName(),
            input.getStoreNumber(),
            input.getCustomerNumber(), addressDetails));

    return new CreateCustomerUseCaseOutput(customerDetails);
  }
}
