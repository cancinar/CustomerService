package com.cinar.customerservice.core.domain;

import com.cinar.customerservice.base.domain.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CustomerDetailsDomain extends Domain {

  private String name;
  private String commercialName;
  private Long storeNumber;
  private Long customerNumber;
  private AddressDetailsDomain addressDetails;
}
