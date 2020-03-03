package com.rms.driver;

import org.jboss.logging.Logger;

public class Log4j {

    public static final Logger log = Logger.getLogger(Log4j.class);

    public void info() {
        log.info("Info level");
    }

}