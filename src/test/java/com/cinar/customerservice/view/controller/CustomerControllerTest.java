package com.cinar.customerservice.view.controller;

import static com.cinar.customerservice.generator.CustomerDetailsDtoGenerator.randomCustomerDetailsDto;
import static com.cinar.customerservice.generator.RandomGenerator.randomId;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cinar.customerservice.core.usecase.CreateCustomerUseCase;
import com.cinar.customerservice.core.usecase.FindCustomerUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private FindCustomerUseCase findCustomerUseCase;

  @MockBean
  private CreateCustomerUseCase createCustomerUseCase;

  @MockBean
  private CustomerController customerController;

  @Test
  void findCustomerDetails_thenReturns200() throws Exception {
    mockMvc.perform(get("/api/customers")
            .queryParam("id", randomId())
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void createCustomerDetails_thenReturns200() throws Exception {
    mockMvc.perform(post("/api/customers")
            .content(convertToJson(randomCustomerDetailsDto()))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  private String convertToJson(Object o) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(o);
  }
}
