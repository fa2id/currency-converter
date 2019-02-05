package com.fa2id.app.application;

import com.fa2id.app.currency.Currencies;
import com.fa2id.app.file.FileFactory;
import com.fa2id.app.file.FileReader;

import java.io.FileNotFoundException;

/**
 * This is the class to initialize the application. Parsing and saveing new currencies to database is the role
 * of this class.
 *
 * @author farid
 * www.fa2id.com
 */
public class ApplicationInitializerImplementation implements ApplicationInitializer {


    /**
     * This method is for initializing application using an external database file to fill the database.
     * The method tries to run the parser, then creates new currencies and save to the database.
     *
     * @param fileName is the name of the external database file. It is used for adding data to database.
     * @return true if the number of saved currencies is more than 0.
     * @throws FileNotFoundException if there is any error related to the loading files.
     */
    @Override
    public boolean initializeApplication(final String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty())
            throw new FileNotFoundException("File name is Empty!");
        if (fileName.contains("/") || fileName.contains("\\"))
            throw new FileNotFoundException("File name is not right!");
        FileReader fileReader = FileFactory.createFileReader();
        String text = fileReader.readFileToString(fileName);
        if (text == null || text.isEmpty() || !text.contains("\n"))
            return false;
        int numberOfSavedData = parseAndSave(text);
        return numberOfSavedData > 0;
    }


    /**
     * This method is parsing the text from the file and creating new currencies and saving to database.
     *
     * @param text is the full text read by FileReade and passed as argument to this method.
     * @return the number of saved currencies in the database.
     */
    private int parseAndSave(final String text) {
        if (text == null || text.isEmpty())
            return 0;
        int savedData = 0;
        try {
            String lines[] = text.split("\n");
            for (String line : lines) {
                int atCharIndex = line.indexOf('@');
                int dollarCharIndex = line.indexOf('$');
                if ((atCharIndex > 2)
                        && (dollarCharIndex > 4)
                        && containsJustOne(line, '@')
                        && containsJustOne(line, '$')
                        && ((line.length() - dollarCharIndex) > 1)
                        && ((dollarCharIndex - atCharIndex) > 1)
                        && line.substring(dollarCharIndex + 1).matches("([0-9]*[.])?[0-9]+")) {
                    String currencyId = line.substring(0, atCharIndex);
                    String currencyName = line.substring(atCharIndex + 1, dollarCharIndex);
                    double valueInUSD = Double
                            .parseDouble(line.substring(dollarCharIndex + 1).replace("-", ""));
                    if (currencyId.length() != 3)
                        continue;
                    if (currencyName.isEmpty())
                        continue;
                    if (Double.compare(valueInUSD, 0.0) <= 0)
                        continue;
                    Currencies currencies = Currencies.getInstance();
                    String currencyIdUpperCase = currencyId.toUpperCase();
                    currencies.addToDataBase(currencyIdUpperCase, currencyName, valueInUSD);
                    savedData++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION: " + e.getMessage());
        }
        return savedData;
    }


    /**
     * This method is a helper method to detect if a line of text has more than one character inside.
     *
     * @param string    is the line to be scanned character by character.
     * @param character is the character which has to be detected if it is duplicated in the line.
     * @return true if there is two or more of the character in the string line.
     */
    private boolean containsJustOne(String string, char character) {
        boolean seen = false;
        char chars[] = string.toCharArray();
        for (char c : chars) {
            if (c == character) {
                if (!seen)
                    seen = true;
                else
                    return false;
            }
        }
        return true;
    }
}
