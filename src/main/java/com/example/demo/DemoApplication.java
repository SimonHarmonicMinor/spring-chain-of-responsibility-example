package com.example.demo;

import com.example.demo.enrichment.EnrichmentStepFacade;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private EnrichmentStepFacade enrichmentStepFacade;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void onStart() {
		System.out.println("Result message: " + enrichmentStepFacade.enrich(
				new Message(
						Map.of(
								"ip", "10.10.10.10",
								"userId", "someId",
								"SESSIONID", "dfsjklfdjsafsdfadfa"
						)
				)
		));
	}
}
