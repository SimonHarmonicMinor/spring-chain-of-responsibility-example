package com.example.demo.enrichment;

import com.example.demo.Message;
import com.example.demo.repo.GeoLocationRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class GeoLocationEnrichmentStep extends AbstractEnrichmentStep {

  private final GeoLocationRepository geoLocationRepository;

  public GeoLocationEnrichmentStep(
      GeoLocationRepository geoLocationRepository) {
    this.geoLocationRepository = geoLocationRepository;
  }

  @Override
  protected Optional<Message> enrichAndApplyNext(Message message) {
    return message.getValue("ip")
        .flatMap(geoLocationRepository::findGeoLocationByIp)
        .map(geo -> message.with("geo", geo.toString()));
  }
}
