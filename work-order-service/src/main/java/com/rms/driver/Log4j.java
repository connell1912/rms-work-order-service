package com.rms.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j {

    public static final Logger LOGGER = LoggerFactory.getLogger(Log4j.class);

	public void info(String message) {
		LOGGER.info("Let's assert some logs! " + message);
	}

}