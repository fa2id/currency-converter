package com.fa2id.app.console;

/**
 * This is the factory class for Console Runner.
 *
 * @author Farid Ariafard
 * www.fa2id.com
 */
public class ConsoleRunnerFactory {


    /**
     * This method creates a ConsoleRunner object.
     *
     * @return ConsoleRunner object
     */
    public static ConsoleRunner create() {
        return new ConsoleRunnerImplementation();
    }
}
