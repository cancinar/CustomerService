package com.cinar.customerservice.client;

import com.cinar.customerservice.base.annotation.ClientService;
import com.cinar.customerservice.core.client.GetGeocodingClient;
import com.cinar.customerservice.core.domain.AddressDetailsDomain;
import com.cinar.customerservice.view.dto.GeocodeDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@ClientService
@RequiredArgsConstructor
public class GetGeocodingClientImpl implements GetGeocodingClient {

  @Value("${client.gecodeService.getGeocode.url}")
  private String getGeoCodeUrl;

  private final RestTemplate restTemplate;

  @Override
  public AddressDetailsDomain execute(String address) {
    final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
        .scheme("http")
        .host(getGeoCodeUrl)
        .port(8081)
        .path("api/geocode")
        .queryParam("address", address);

    final GeocodeDto geocodeDto = restTemplate.postForEntity(uriComponentsBuilder.toUriString(),
        address,
        GeocodeDto.class).getBody();

    return Optional.ofNullable(geocodeDto)
        .map((dto -> new AddressDetailsDomain(address, geocodeDto.getLatitude(),
            geocodeDto.getLongitude())))
        .orElse(new AddressDetailsDomain());
  }
}
