package com.fa2id.app.user;

/**
 * The User Interaction is the interface for getting input from the user and printing.
 *
 * @author farid
 * www.fa2id.com
 */
public interface UserInteraction {

    /**
     * This method is for getting input from user.
     *
     * @return the string written by user.
     */
    String getInput();


    /**
     * This Method is for printing something for the user.
     *
     * @param text is the exact text which has to be printed.
     */
    void printOutput(String text);
}
