package com.cinar.customerservice.db.repository.impl;

import static com.cinar.customerservice.generator.CustomerDetailsGenerator.randomCustomerDetailsWithGeocode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.repository.CustomerDetailsDomainRepository;
import com.cinar.customerservice.db.entity.CustomerDetails;
import com.cinar.customerservice.db.repository.CustomerDetailsJPARepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerDetailsDomainRepositoryImplTest {

  private CustomerDetailsDomainRepository customerDetailsDomainRepository;

  @Mock
  private CustomerDetailsJPARepository customerDetailsJPARepository;

  @BeforeEach
  public void init() {
    customerDetailsDomainRepository = new CustomerDetailsDomainRepositoryImpl(
        customerDetailsJPARepository);
  }

  @Test
  public void findById_givenCustomerDetails_thenReturn() {
    CustomerDetails customerDetails = randomCustomerDetailsWithGeocode();

    when(customerDetailsJPARepository.findById(customerDetails.getId()))
        .thenReturn(Optional.of(customerDetails));

    final CustomerDetailsDomain customerDetailsDomain = customerDetailsDomainRepository.findById(
            customerDetails.getId())
        .get();

    assertEquals(customerDetails.toCustomerDetailsDomain(), customerDetailsDomain);
  }

  @Test
  public void findByCustomerNumber_givenCustomerDetails_thenReturn() {
    CustomerDetails customerDetails = randomCustomerDetailsWithGeocode();

    when(customerDetailsJPARepository.findByCustomerNumber(customerDetails.getCustomerNumber()))
        .thenReturn(Optional.of(customerDetails));

    final CustomerDetailsDomain customerDetailsDomain = customerDetailsDomainRepository.findByCustomerNumber(
            customerDetails.getCustomerNumber())
        .get();

    assertEquals(customerDetails.toCustomerDetailsDomain(), customerDetailsDomain);
  }

  @Test
  public void create_givenCustomerDetails_thenReturn() {
    CustomerDetails customerDetails = randomCustomerDetailsWithGeocode();

    when(customerDetailsJPARepository.save(any(CustomerDetails.class)))
        .thenAnswer(i -> i.getArguments()[0]);
    when(customerDetailsJPARepository.findByCustomerNumber(customerDetails.getCustomerNumber()))
        .thenReturn(Optional.empty());

    final CustomerDetailsDomain customerDetailsDomain = customerDetailsDomainRepository.create(
        customerDetails.toCustomerDetailsDomain());

    assertEquals(customerDetails.toCustomerDetailsDomain(), customerDetailsDomain);
  }

  @Test
  public void create_givenCustomerDetails_whenAlreadyExist_thenReturn() {
    CustomerDetails customerDetails = randomCustomerDetailsWithGeocode();

    when(customerDetailsJPARepository.findByCustomerNumber(customerDetails.getCustomerNumber()))
        .thenReturn(Optional.of(customerDetails));

    final CustomerDetailsDomain customerDetailsDomain = customerDetailsDomainRepository.create(
        customerDetails.toCustomerDetailsDomain());

    verify(customerDetailsJPARepository, never()).save(any(CustomerDetails.class));

    assertEquals(customerDetails.toCustomerDetailsDomain(), customerDetailsDomain);
  }
}
