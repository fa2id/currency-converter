package com.fa2id.app.currency;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Farid Ariafard
 * www.fa2id.com
 */
public class Currencies {

    private static volatile Currencies currenciesInstance;

    private final Map<String, Currency> currenciesDatabase;


    private Currencies() {
        currenciesDatabase = new HashMap<>();
        Currency usdCurrency = new Currency("USD", "US Dollar", 1);
        currenciesDatabase.put("USD", usdCurrency);
    }


    public static Currencies getInstance() {
        if (currenciesInstance == null) {
            synchronized (Currencies.class) {
                if (currenciesInstance == null)
                    currenciesInstance = new Currencies();
            }
        }
        return currenciesInstance;
    }


    public void addToDataBase(final String currencyId, final String currencyName, final double valueInUSD)
            throws Exception {
        if (currencyId == null || currencyId.length() != 3) {
            throw new Exception("Bad currencyId (Null or not 3 characters). currencyId must be 3 characters! " +
                    "currencyId= " + currencyId);
        }
        if (currencyName == null || currencyName.isEmpty()) {
            throw new Exception("Bad currencyName (Null or empty)! currencyName= " + currencyName);
        }
        if (Double.compare(valueInUSD, 0.0) < 0) {
            throw new Exception("Bad currencyName (Null or empty)! currencyName= " + currencyName);
        }
        String currencyIdUpperCase = currencyId.toUpperCase();
        if (currenciesDatabase.containsKey(currencyIdUpperCase)) {
            throw new Exception("Currency " + currencyIdUpperCase + " already exists! " +
                    "You can only add new currencies.");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double valueInUsdToSave = Double.valueOf(decimalFormat.format(valueInUSD));
        Currency currency = new Currency(currencyIdUpperCase, currencyName, valueInUsdToSave);
        currenciesDatabase.put(currencyIdUpperCase, currency);
    }


    public Currency getCurrency(final String currencyId) throws Exception {
        if (currencyId == null || currencyId.length() != 3) {
            throw new Exception("Bad currencyId (Null or not 3 characters). currencyId must be 3 characters!");
        }
        String currencyIdUpperCase = currencyId.toUpperCase();
        if (!currenciesDatabase.containsKey(currencyIdUpperCase))
            throw new Exception("The currency " + currencyIdUpperCase + " does not exist!");
        return currenciesDatabase.get(currencyIdUpperCase);
    }


    public Map<String, Currency> getDatabase() {
        return currenciesDatabase;
    }
}
