package com.example.demo.repo;

import java.util.Optional;

public interface AgeRepository {
  Optional<Integer> findAgeByUserId(String userId);
}
