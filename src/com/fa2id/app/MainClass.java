package com.fa2id.app;

import com.fa2id.app.application.Application;
import com.fa2id.app.application.CurrencyConverterApplication;

/**
 * This is the main class which has the Main method in order to run the program.
 * Argument is expected. Arg[0] must be the database file name.
 *
 * @author farid
 * www.fa2id.com
 */
public class MainClass {

    /**
     * This is the main method to run the program. It creates a currency converter application and starts it.
     *
     * @param args Argument is expected for this program. arg[0] must be the database file name like "database.txt"
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            Application application = new CurrencyConverterApplication();
            application.start(fileName);
        } else {
            System.out.println("Please add the database filename as the first argument. (e.g. database.txt)");
        }
    }
}
