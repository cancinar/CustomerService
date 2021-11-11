package com.cinar.customerservice.db.entity;

import com.cinar.customerservice.core.domain.AddressDetailsDomain;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Embeddable
@SuperBuilder
public class AddressDetail {

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private Double latitude;

  @Column(nullable = false)
  private Double longitude;

  public AddressDetailsDomain toAddressDetailsDomain() {
    return AddressDetailsDomain.builder()
        .address(this.address)
        .latitude(this.latitude)
        .longitude(this.longitude)
        .build();
  }
}
