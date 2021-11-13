package com.cinar.customerservice.core.domain;

import com.cinar.customerservice.base.domain.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class AddressDetailsDomain extends Domain {

  private String address;
  private Double latitude;
  private Double longitude;
}
