package com.example.demo.enrichment;

import com.example.demo.Message;
import java.util.Optional;

public abstract class AbstractEnrichmentStep implements EnrichmentStep {

  private EnrichmentStep next;

  @Override
  public final void setNext(EnrichmentStep step) {
    this.next = step;
  }

  @Override
  public final Message enrich(Message message) {
    return enrichAndApplyNext(message)
        .map(enrichedMessage -> next.enrich(enrichedMessage))
        .orElseGet(() -> next.enrich(message));
  }

  protected abstract Optional<Message> enrichAndApplyNext(Message message);
}
