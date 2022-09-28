package com.example.demo.repo;

import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
class StubPhoneNumberRepository implements
    PhoneNumberRepository {

  @Override
  public Optional<String> findPhoneNumber(String sessionId) {
    return Optional.of("78005553535");
  }
}
