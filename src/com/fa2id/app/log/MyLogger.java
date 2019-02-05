package com.fa2id.app.log;

import com.fa2id.app.currency.Currencies;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The logger class which is singleton, and is responsible for logging the application.
 *
 * @author Farid Ariafard
 * www.fa2id.com
 */
public class MyLogger {

    private static volatile MyLogger myLoggerInstance;

    private Logger logger;

    private MyLogger() {
        logger = Logger.getLogger(MyLogger.class.getName());
        try {
            logger.setUseParentHandlers(false);
            Handler fileHandler = new FileHandler("CurrencyConverterAppLog.log");
            logger.addHandler(fileHandler);
            fileHandler.setLevel(Level.ALL);
            logger.setLevel(Level.ALL);
            logger.config("Configuration done.");
        } catch (Exception e) {
            System.out.println("LOGGER problem" + e.getMessage());
        }
    }


    /**
     * This method is for logging to the file. Level is INFO.
     *
     * @param text is the log text.
     */
    private void logInfo(final String text) {
        logger.log(Level.INFO, text);
    }


    /**
     * This method is for logging to the file. Level is INFO.
     *
     * @param text is the log text.
     */
    public static void log(final String text) {
        MyLogger myLogger = getInstance();
        myLogger.logInfo(text);
    }


    private static MyLogger getInstance() {
        if (myLoggerInstance == null) {
            synchronized (Currencies.class) {
                if (myLoggerInstance == null)
                    myLoggerInstance = new MyLogger();
            }
        }
        return myLoggerInstance;
    }
}
