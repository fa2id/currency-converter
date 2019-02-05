package com.fa2id.app.application;

import com.fa2id.app.console.ConsoleRunner;
import com.fa2id.app.console.ConsoleRunnerImplementation;

/**
 * @author farid
 * www.fa2id.com
 */
public class CurrencyConverterApplication implements Application {

    private boolean isInitiated(final String fileName) {
        ApplicationInitializer applicationInitializer = new ApplicationInitializerImplementation();
        try {
            return applicationInitializer.initializeApplication(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void start(final String fileName) {
        ConsoleRunner consoleRunner = new ConsoleRunnerImplementation();
        boolean isAppInitiated = isInitiated(fileName);
        if (!isAppInitiated) {
            consoleRunner.runPrint("App not initiated! Please, run again!");
            return;
        }
        consoleRunner.runTitle();
        consoleRunner.runMenu();
        consoleRunner.runEnding();
    }
}
