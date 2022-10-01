package com.example.demo.enrichment;

import com.example.demo.Message;
import com.example.demo.repo.PhoneNumberRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class PhoneNumberEnrichmentStep extends AbstractEnrichmentStep {

  private final PhoneNumberRepository phoneNumberRepository;

  public PhoneNumberEnrichmentStep(
      PhoneNumberRepository phoneNumberRepository
  ) {
    this.phoneNumberRepository = phoneNumberRepository;
  }

  @Override
  protected Optional<Message> enrichAndApplyNext(Message message) {
    return message.getValue("SESSIONID")
        .flatMap(phoneNumberRepository::findPhoneNumber)
        .map(phoneNumber ->
            message.with("phoneNumber", phoneNumber)
        );
  }
}
