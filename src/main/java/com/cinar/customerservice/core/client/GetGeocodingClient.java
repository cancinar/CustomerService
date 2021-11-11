package com.cinar.customerservice.core.client;

import com.cinar.customerservice.core.domain.AddressDetailsDomain;

@FunctionalInterface
public interface GetGeocodingClient {

  AddressDetailsDomain execute(String address);
}
