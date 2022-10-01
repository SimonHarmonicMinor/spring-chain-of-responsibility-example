package com.example.demo.enrichment;

import com.example.demo.Message;

public interface EnrichmentStep extends ChainElement<EnrichmentStep> {
  Message enrich(Message message);
}
