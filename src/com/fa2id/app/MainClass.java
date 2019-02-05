package com.fa2id.app;

import com.fa2id.app.application.Application;
import com.fa2id.app.application.CurrencyConverterApplication;

/**
 * @author farid
 * www.fa2id.com
 */
public class MainClass {

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
