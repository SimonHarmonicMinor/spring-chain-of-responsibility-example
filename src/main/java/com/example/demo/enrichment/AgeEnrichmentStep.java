package com.example.demo.enrichment;

import com.example.demo.Message;
import com.example.demo.repo.AgeRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class AgeEnrichmentStep extends AbstractEnrichmentStep {
  private final AgeRepository ageRepository;

  AgeEnrichmentStep(AgeRepository ageRepository) {
    this.ageRepository = ageRepository;
  }

  @Override
  protected Optional<Message> enrichAndApplyNext(Message message) {
    return message.getValue("userId")
        .flatMap(ageRepository::findAgeByUserId)
        .map(age -> message.with("age", age + ""));
  }
}
