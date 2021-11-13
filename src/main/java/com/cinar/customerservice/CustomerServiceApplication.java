package com.cinar.customerservice;

import com.cinar.customerservice.view.controller.CustomerController;
import com.cinar.customerservice.view.dto.CustomerDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  public CommandLineRunner initDBData(CustomerController customerController) {
    return (arg) -> {
      try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
          .getResourceAsStream("initialData.json")) {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDetailsDto customerDetails = mapper.readValue(inputStream,
            CustomerDetailsDto.class);
        customerController.createCustomer(customerDetails);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }

}
