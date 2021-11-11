package com.cinar.customerservice.db.entity;

import com.cinar.customerservice.base.db.entity.BaseEntity;
import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerDetails extends BaseEntity {

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String commercialName;

  @Column(nullable = false)
  private Long storeNumber;

  @Column(nullable = false)
  private Long customerNumber;

  @Embedded
  private AddressDetail addressDetail;

  public CustomerDetailsDomain toCustomerDetailsDomain() {
    return CustomerDetailsDomain.builder()
        .name(this.name)
        .commercialName(this.commercialName)
        .storeNumber(this.storeNumber)
        .customerNumber(this.customerNumber)
        .addressDetails(this.addressDetail.toAddressDetailsDomain())
        .build();
  }
}
