package com.example.demo.repo;

import java.util.Optional;

public interface PhoneNumberRepository {
    Optional<String> findPhoneNumber(String sessionId);
}
