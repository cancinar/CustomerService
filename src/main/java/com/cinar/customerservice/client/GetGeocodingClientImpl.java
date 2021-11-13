package com.cinar.customerservice.client;

import com.cinar.customerservice.base.annotation.ClientService;
import com.cinar.customerservice.core.client.GetGeocodingClient;
import com.cinar.customerservice.core.domain.AddressDetailsDomain;
import com.cinar.customerservice.view.dto.GeocodeDto;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@ClientService
@AllArgsConstructor
public class GetGeocodingClientImpl implements GetGeocodingClient {

  private final RestTemplate restTemplate;

  @Override
  public AddressDetailsDomain execute(String address) {
    final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
        .scheme("http")
        .host("geocode-service")
        .port(8081)
        .path("api/geocode")
        .queryParam("address", address);

    final GeocodeDto geocodeDto = restTemplate.postForEntity(uriComponentsBuilder.toUriString(),
        address,
        GeocodeDto.class).getBody();

    return new AddressDetailsDomain(address, geocodeDto.getLatitude(), geocodeDto.getLongitude());
  }
}
