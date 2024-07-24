package com.algonquin.cst8288.assignment2.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton Logger class for logging messages with different log levels.
 * The LMSLogger class provides methods to log messages and exceptions
 * with specified log levels.
 */
public class LMSLogger {
    private static LMSLogger instance;
    private static final Logger logger = Logger.getLogger(LMSLogger.class.getName());

    /**
     * Private constructor to prevent instantiation.
     * Initializes the logger.
     */
    private LMSLogger() {
        // Initialize the logger here
    }

    /**
     * Returns the singleton instance of the LMSLogger.
     * Uses double-checked locking to ensure thread-safe lazy initialization.
     *
     * @return the singleton instance of LMSLogger
     */
    public static LMSLogger getInstance() {
        if (instance == null) {
            synchronized (LMSLogger.class) {
                if (instance == null) {
                    instance = new LMSLogger();
                }
            }
        }
        return instance;
    }

    /**
     * Logs a message with the specified log level.
     *
     * @param level   the log level for the message
     * @param message the message to be logged
     */
    public void log(LogLevel level, String message) {
        switch (level) {
            case TRACE:
                logger.log(Level.FINEST, message);
                break;
            case DEBUG:
                logger.log(Level.FINE, message);
                break;
            case INFO:
                logger.log(Level.INFO, message);
                break;
            case WARN:
                logger.log(Level.WARNING, message);
                break;
            case ERROR:
                logger.log(Level.SEVERE, message);
                break;
        }
    }

    /**
     * Logs a message and a throwable with the specified log level.
     *
     * @param level   the log level for the message
     * @param message the message to be logged
     * @param thrown  the throwable to be logged
     */
    public void log(LogLevel level, String message, Throwable thrown) {
        switch (level) {
            case TRACE:
                logger.log(Level.FINEST, message, thrown);
                break;
            case DEBUG:
                logger.log(Level.FINE, message, thrown);
                break;
            case INFO:
                logger.log(Level.INFO, message, thrown);
                break;
            case WARN:
                logger.log(Level.WARNING, message, thrown);
                break;
            case ERROR:
                logger.log(Level.SEVERE, message, thrown);
                break;
        }
    }
}