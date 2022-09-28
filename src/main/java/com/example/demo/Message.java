package com.example.demo;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Message {
  private final Map<String, String> content;

  public Message(Map<String, String> content) {
    this.content = content;
  }

  public Optional<String> getValue(String field) {
    return ofNullable(content.get(field));
  }

  public Message with(String field, String value) {
    final var contentCopy = new HashMap<>(content);
    contentCopy.put(field, value);
    return new Message(contentCopy);
  }
}
