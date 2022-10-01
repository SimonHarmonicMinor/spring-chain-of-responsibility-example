package com.example.demo.repo;

import java.util.Optional;

public interface GeoLocationRepository {
  Optional<GeoLocation> findGeoLocationByIp(String ip);
}
