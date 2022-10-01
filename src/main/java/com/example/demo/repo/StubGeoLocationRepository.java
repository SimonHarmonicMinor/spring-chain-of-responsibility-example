package com.example.demo.repo;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class StubGeoLocationRepository implements
    GeoLocationRepository {

  @Override
  public Optional<GeoLocation> findGeoLocationByIp(String ip) {
    return Optional.of(new GeoLocation(12, 13));
  }
}
