package com.cinar.customerservice.db.repository;

import com.cinar.customerservice.base.annotation.DomainRepository;
import com.cinar.customerservice.db.entity.CustomerDetails;
import org.springframework.data.repository.CrudRepository;

@DomainRepository
public interface CustomerDetailsJPARepository extends CrudRepository<CustomerDetails, String> {

}
