package com.fa2id.app.user;

import java.util.Scanner;

/**
 * This class is an implementation of the UserInteraction for user interactions
 * such as getting input or printing text.
 *
 * @author farid
 * www.fa2id.com
 */
public class UserInteractionImplementation implements UserInteraction {

    /**
     * This method is for getting input from user.
     *
     * @return the string written by user.
     */
    @Override
    public String getInput() {
        final Scanner scanner = new Scanner(System.in, "UTF-8");
        return scanner.nextLine().trim();
    }


    /**
     * This Method is for printing something for the user.
     *
     * @param text is the exact text which has to be printed.
     */
    @Override
    public void printOutput(final String text) {
        System.out.println(text);
    }
}
