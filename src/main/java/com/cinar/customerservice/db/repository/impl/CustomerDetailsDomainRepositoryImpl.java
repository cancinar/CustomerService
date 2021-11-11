package com.cinar.customerservice.db.repository.impl;

import com.cinar.customerservice.base.annotation.DomainRepository;
import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.repository.CustomerDetailsDomainRepository;
import com.cinar.customerservice.db.entity.AddressDetail;
import com.cinar.customerservice.db.entity.CustomerDetails;
import com.cinar.customerservice.db.repository.CustomerDetailsJPARepository;
import java.util.Optional;
import lombok.AllArgsConstructor;

@DomainRepository
@AllArgsConstructor
public class CustomerDetailsDomainRepositoryImpl implements CustomerDetailsDomainRepository {

  private CustomerDetailsJPARepository customerDetailsJPARepository;

  @Override
  public Optional<CustomerDetailsDomain> findById(String id) {
    return customerDetailsJPARepository.findById(id)
        .map(CustomerDetails::toCustomerDetailsDomain);
  }

  @Override
  public CustomerDetailsDomain create(CustomerDetailsDomain customerDetailsDomain) {
    final CustomerDetails customerDetails = CustomerDetails.builder()
        .name(customerDetailsDomain.getName())
        .customerNumber(customerDetailsDomain.getCustomerNumber())
        .commercialName(customerDetailsDomain.getCommercialName())
        .storeNumber(customerDetailsDomain.getStoreNumber())
        .addressDetail(AddressDetail.builder()
            .address(customerDetailsDomain.getAddressDetails().getAddress())
            .latitude(customerDetailsDomain.getAddressDetails().getLatitude())
            .longitude(customerDetailsDomain.getAddressDetails().getLongitude())
            .build())
        .build();
    return customerDetailsJPARepository.save(customerDetails).toCustomerDetailsDomain();
  }
}
