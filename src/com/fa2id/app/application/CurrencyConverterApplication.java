package com.fa2id.app.application;

import com.fa2id.app.console.ConsoleRunner;
import com.fa2id.app.console.ConsoleRunnerFactory;
import com.fa2id.app.log.MyLogger;

/**
 * This is a Currency Converter Application. This class helps to initialize and run the application.
 *
 * @author farid
 * www.fa2id.com
 */
public class CurrencyConverterApplication implements Application {


    /**
     * This method is for initialization of the application. It gets the file name as an argument.
     * The file is acting as a database which has to be read and parsed from the file.
     * Returns true if the initialization is completed without any error.
     *
     * @param fileName is the name of the external file to be read.
     * @return the status after initialization. True if it is done completely.
     */
    private boolean isInitiated(final String fileName) {
        ApplicationInitializer applicationInitializer = new ApplicationInitializerImplementation();
        try {
            return applicationInitializer.initializeApplication(fileName);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
        return false;
    }


    /**
     * To start the application, initialization is needed. This initialization will be done using a file
     * acting as database. isAppInitiated returns true if the initialization is complete without error. Then,
     * the console runner will help to run, print, get user input, and print result for the customer.
     *
     * @param fileName is the name of the external database file. It is used for adding data to database.
     */
    @Override
    public void start(final String fileName) {
        MyLogger.log("Application started.");
        ConsoleRunner consoleRunner = ConsoleRunnerFactory.create();
        boolean isAppInitiated = isInitiated(fileName);
        if (!isAppInitiated) {
            consoleRunner.runPrint("App not initiated! Please recheck your file name and run again!");
            return;
        }
        MyLogger.log("Application initialized.");
        consoleRunner.runTitle();
        consoleRunner.runMenu();
        consoleRunner.runEnding();
        MyLogger.log("Application ended.");
    }
}
