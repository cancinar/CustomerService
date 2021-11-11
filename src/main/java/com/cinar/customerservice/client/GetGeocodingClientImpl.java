package com.cinar.customerservice.client;

import com.cinar.customerservice.base.annotation.ClientService;
import com.cinar.customerservice.core.client.GetGeocodingClient;
import com.cinar.customerservice.core.domain.AddressDetailsDomain;
import java.util.Random;

@ClientService
public class GetGeocodingClientImpl implements GetGeocodingClient {

  @Override
  public AddressDetailsDomain execute(String address) {
    Random r = new Random();
    Double latitude = 10 + (35 - 10) * r.nextDouble();
    Double longitude = 10 + (35 - 10) * r.nextDouble();
    return new AddressDetailsDomain(address, latitude, longitude);
  }
}
