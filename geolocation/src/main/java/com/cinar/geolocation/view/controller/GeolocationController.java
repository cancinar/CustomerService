package com.cinar.geolocation.view.controller;

import com.cinar.geolocation.view.dto.GeocodeDto;
import java.util.Random;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/geocode")
public class GeolocationController {

  @PostMapping
  public ResponseEntity<GeocodeDto> getGeocode(@RequestParam String address) {
    Random r = new Random();
    Double latitude = 10 + (35 - 10) * r.nextDouble();
    Double longitude = 10 + (35 - 10) * r.nextDouble();
    return ResponseEntity.ok(new GeocodeDto(latitude, longitude));
  }
}
