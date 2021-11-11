package com.cinar.customerservice.core.usecase.io;

import com.cinar.customerservice.base.usecase.Input;
import lombok.Data;

@Data
public class CreateCustomerUseCaseInput implements Input {

  private String name;
  private String commercialName;
  private Long storeNumber;
  private Long customerNumber;
  private String address;

  @Override
  public void validate() {
  }
}
