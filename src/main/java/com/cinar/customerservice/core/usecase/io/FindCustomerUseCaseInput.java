package com.cinar.customerservice.core.usecase.io;

import com.cinar.customerservice.base.usecase.Input;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindCustomerUseCaseInput implements Input {

  private String id;

  @Override
  public void validate() {
  }
}
