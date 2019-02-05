package com.fa2id.app.console;

/**
 * This is the interface to run the application using console. Console based application must have these methods.
 *
 * @author farid
 * www.fa2id.com
 */
public interface ConsoleRunner {

    /**
     * This method is to print and run the title part of the application.
     */
    void runTitle();


    /**
     * This method is to print and run the main part of the application.
     */
    void runMenu();


    /**
     * This method is to print a text in the application.
     */
    void runPrint(String text);


    /**
     * This method is to print and run the ending part of the application.
     */
    void runEnding();
}
