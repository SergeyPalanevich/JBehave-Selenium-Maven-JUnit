package com.epam.bdd.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    private static final Logger LOGGER = LogManager.getRootLogger();

    private LoggerUtils() {
    }
    
    public static void info(String message) {
        LOGGER.info(message);
    }
}
