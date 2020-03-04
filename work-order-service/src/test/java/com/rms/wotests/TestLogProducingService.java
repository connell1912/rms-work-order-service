package com.rms.wotests;

import static org.assertj.core.api.Assertions.assertThat;

import com.rms.driver.Log4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLogProducingService {

	private Log4j service = new Log4j();

	@BeforeEach
	public void clearLoggingStatements() {
		StaticLogbackAppender.clearEvents();
	}

	@Test
	public void testAssertingLoggingStatementsA() {
		service.info("A");
		assertThat(StaticLogbackAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! A");
	}

	@Test
	public void testAssertingLoggingStatementsB() {
		service.info("B");
		assertThat(StaticLogbackAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! B");
	}

}