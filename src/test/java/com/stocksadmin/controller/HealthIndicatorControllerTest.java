package com.stocksadmin.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

public class HealthIndicatorControllerTest {

	@InjectMocks
	private HealthIndicatorController healthIndicatorController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void healthIndicatorShouldReturnOkWhenAppIsUpAndRunning() {
		Health health = healthIndicatorController.health();
		Assertions.assertEquals(Status.UP, health.getStatus());
	}

}
