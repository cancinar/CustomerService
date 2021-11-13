package com.cinar.customerservice;

import com.cinar.customerservice.core.domain.CustomerDetailsDomain;
import com.cinar.customerservice.core.usecase.CreateCustomerUseCase;
import com.cinar.customerservice.core.usecase.io.CreateCustomerUseCaseInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }

  @Bean
  public CommandLineRunner initDBData(CreateCustomerUseCase createCustomerUseCase) {
    return (arg) -> {
      try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
          .getResourceAsStream("initialData.json")) {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDetailsDomain customerDetails = mapper.readValue(inputStream,
            CustomerDetailsDomain.class);
        createCustomerUseCase.run(new CreateCustomerUseCaseInput(customerDetails.getName(),
            customerDetails.getCommercialName(), customerDetails.getStoreNumber(),
            customerDetails.getCustomerNumber(), customerDetails.getAddressDetails().getAddress()));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }

}
