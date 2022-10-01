package com.example.demo.enrichment;

import com.example.demo.Message;

class NoOpEnrichmentStep implements EnrichmentStep {

  @Override
  public Message enrich(Message message) {
    return message;
  }

  @Override
  public void setNext(EnrichmentStep step) {
    // no op
  }
}
