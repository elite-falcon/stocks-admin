package com.stocksadmin.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

public class HealthIndicatorControllerTest {

	@InjectMocks
	private HealthIndicatorController healthIndicatorController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void healthIndicatorShouldReturnOkWhenAppIsUpAndRunning() {
		Health health = healthIndicatorController.health();
		Assert.assertEquals(Status.UP, health.getStatus());
	}

}
