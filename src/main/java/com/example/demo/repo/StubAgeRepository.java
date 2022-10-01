package com.example.demo.repo;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class StubAgeRepository implements AgeRepository {

  @Override
  public Optional<Integer> findAgeByUserId(String userId) {
    return Optional.of(42);
  }
}
