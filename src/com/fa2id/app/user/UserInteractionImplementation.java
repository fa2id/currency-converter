package com.fa2id.app.user;

import java.util.Scanner;

/**
 * @author farid
 * www.fa2id.com
 */
public class UserInteractionImplementation implements UserInteraction {

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        return scanner.nextLine().trim();
    }

    @Override
    public void printOutput(final String text) {
        System.out.println(text);
    }
}
