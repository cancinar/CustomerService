package com.cinar.geolocation.view.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class GeocodeDto {

  private Double latitude;
  private Double longitude;
}
