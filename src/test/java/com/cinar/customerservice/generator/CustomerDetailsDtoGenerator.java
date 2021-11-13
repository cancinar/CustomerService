package com.cinar.customerservice.generator;

import static com.cinar.customerservice.generator.RandomGenerator.randomAddress;
import static com.cinar.customerservice.generator.RandomGenerator.randomLong;
import static com.cinar.customerservice.generator.RandomGenerator.randomName;

import com.cinar.customerservice.view.dto.CustomerDetailsDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerDetailsDtoGenerator {

  public static CustomerDetailsDto randomCustomerDetailsDto() {
    return CustomerDetailsDto.builder()
        .address(randomAddress())
        .customerNumber(randomLong())
        .commercialName(randomName())
        .name(randomName())
        .storeNumber(randomLong())
        .build();
  }
}
