package com.cinar.customerservice.core.usecase.io;

import com.cinar.customerservice.base.usecase.Input;
import lombok.Data;

@Data
public class FindCustomerUseCaseInput implements Input {

  private String id;

  @Override
  public void validate() {
  }
}
