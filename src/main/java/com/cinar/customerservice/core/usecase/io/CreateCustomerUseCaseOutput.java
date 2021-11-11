package com.cinar.customerservice.core.usecase.io;

import com.cinar.customerservice.base.usecase.Output;
import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCustomerUseCaseOutput implements Output {

  private CustomerDetailsDomain customerDetails;
}
