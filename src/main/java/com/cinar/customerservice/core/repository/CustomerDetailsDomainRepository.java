package com.cinar.customerservice.core.repository;

import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import java.util.Optional;

public interface CustomerDetailsDomainRepository {

  Optional<CustomerDetailsDomain> findById(String id);

  CustomerDetailsDomain create(CustomerDetailsDomain customerDetailsDomain);

  Optional<CustomerDetailsDomain> findByCustomerNumber(Long customerNumber);
}
