package com.cinar.customerservice.core.domain;

import com.cinar.customerservice.base.domain.Domain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddressDetailsDomain extends Domain {


  private String address;
  private Double latitude;
  private Double longitude;
}
