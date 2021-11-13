package com.cinar.customerservice.generator;

import static com.cinar.customerservice.generator.RandomGenerator.randomAddress;
import static com.cinar.customerservice.generator.RandomGenerator.randomDouble;
import static com.cinar.customerservice.generator.RandomGenerator.randomId;
import static com.cinar.customerservice.generator.RandomGenerator.randomLong;
import static com.cinar.customerservice.generator.RandomGenerator.randomName;

import com.cinar.customerservice.db.entity.AddressDetail;
import com.cinar.customerservice.db.entity.CustomerDetails;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerDetailsGenerator {

  public static CustomerDetails randomCustomerDetails() {
    return CustomerDetails.builder()
        .addressDetail(AddressDetail.builder()
            .address(randomAddress())
            .build())
        .commercialName(randomName())
        .customerNumber(randomLong())
        .name(randomName())
        .storeNumber(randomLong())
        .id(randomId())
        .build();
  }

  public static CustomerDetails randomCustomerDetailsWithGeocode() {
    return CustomerDetails.builder()
        .addressDetail(AddressDetail.builder()
            .address(randomAddress())
            .latitude(randomDouble())
            .longitude(randomDouble())
            .build())
        .commercialName(randomName())
        .customerNumber(randomLong())
        .name(randomName())
        .storeNumber(randomLong())
        .id(randomId())
        .build();
  }
}
