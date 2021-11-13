package com.cinar.customerservice.core.usecase.io;

import static org.springframework.util.ObjectUtils.isEmpty;

import com.cinar.customerservice.base.exception.ValidationException;
import com.cinar.customerservice.base.usecase.Input;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCustomerUseCaseInput implements Input {

  private String name;
  private String commercialName;
  private Long storeNumber;
  private Long customerNumber;
  private String address;

  @Override
  public void validate() {
    if (isEmpty(name) || isEmpty(commercialName) || isEmpty(storeNumber) || isEmpty(customerNumber)
        || isEmpty(address)) {
      throw new ValidationException(
          "Name, Commercial Name, Store Number, Customer Number or Address cannot be empty!");
    }
  }
}
