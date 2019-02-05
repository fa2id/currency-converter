package com.fa2id.app.application;

import com.fa2id.app.currency.Currencies;
import com.fa2id.app.file.FileReader;
import com.fa2id.app.file.FileReaderImplementation;

import java.io.FileNotFoundException;

/**
 * @author farid
 * www.fa2id.com
 */
public class ApplicationInitializerImplementation implements ApplicationInitializer {


    @Override
    public boolean initializeApplication(final String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty())
            throw new FileNotFoundException("File name is Empty!");
        if (fileName.contains("/") || fileName.contains("\\"))
            throw new FileNotFoundException("File name is not right!");
        FileReader fileReader = new FileReaderImplementation();
        String text = fileReader.readFileToString(fileName);
        if (text == null || text.isEmpty() || !text.contains("\n"))
            return false;
        int numberOfSavedData = parseAndSave(text);
        return numberOfSavedData > 0;
    }


    private int parseAndSave(final String text) {
        if (text == null || text.isEmpty())
            return 0;
        int savedData = 0;
        String lines[] = text.split("\n");
        for (String line : lines) {
            if (containsJustOne(line, '@')
                    && containsJustOne(line, '$')
                    && line.length() - line.indexOf('$') > 1
                    && line.indexOf('$') - line.indexOf('@') > 1) {
                int atCharIndex = line.indexOf('@');
                int dollarCharIndex = line.indexOf('$');
                String currencyId = line.substring(0, atCharIndex);
                String currencyName = line.substring(atCharIndex + 1, dollarCharIndex);
                double valueInUSD = Double.parseDouble(line.substring(dollarCharIndex + 1));
                if (currencyId.length() != 3)
                    continue;
                if (currencyName.isEmpty())
                    continue;
                if (Double.compare(valueInUSD, 0.0) < 0)
                    continue;
                Currencies currencies = Currencies.getInstance();
                String currencyIdUpperCase = currencyId.toUpperCase();
                try {
                    currencies.addToDataBase(currencyIdUpperCase, currencyName, valueInUSD);
                    savedData++;
                } catch (Exception e) {
//                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return savedData;
    }


    private boolean containsJustOne(String string, char character){
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
