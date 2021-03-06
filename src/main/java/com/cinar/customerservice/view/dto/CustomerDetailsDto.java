package com.cinar.customerservice.view.dto;

import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class CustomerDetailsDto {

  private String name;
  private String commercialName;
  private Long storeNumber;
  private Long customerNumber;
  private String address;
  private Double latitude;
  private Double longitude;

  public static CustomerDetailsDto fromCustomerDetailsDomain(CustomerDetailsDomain customerDetailsDomain) {
    return CustomerDetailsDto.builder()
        .name(customerDetailsDomain.getName())
        .customerNumber(customerDetailsDomain.getCustomerNumber())
        .storeNumber(customerDetailsDomain.getStoreNumber())
        .commercialName(customerDetailsDomain.getCommercialName())
        .address(customerDetailsDomain.getAddressDetails().getAddress())
        .longitude(customerDetailsDomain.getAddressDetails().getLongitude())
        .latitude(customerDetailsDomain.getAddressDetails().getLongitude())
        .build();
  }
}
