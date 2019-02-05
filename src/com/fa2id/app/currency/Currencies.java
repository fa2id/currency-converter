package com.fa2id.app.currency;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a class acting as a database. This class is a singleton class.
 *
 * The usage of this class is for storing and retrieving currencies.
 *
 * @author Farid Ariafard
 * www.fa2id.com
 */
public class Currencies {

    private static volatile Currencies currenciesInstance;

    /**
     * This is the map which is acting as a database.
     *
     * The key is the currency ID like "USD", and the value is the corresponding Currency object.
     */
    private final Map<String, Currency> currenciesDatabase;


    /**
     * Initializing database, and adding USD currency as default currency in database.
     */
    private Currencies() {
        currenciesDatabase = new HashMap<>();
        Currency usdCurrency = new Currency("USD", "US Dollar", 1);
        currenciesDatabase.put("USD", usdCurrency);
    }

    /**
     * Returns the currenciesInstance.
     *
     * If it is null, first it instantiates the currenciesInstance object, then returns it.
     *
     * @return the currenciesInstance which is the only object of this class in the entire application.
     */
    public static Currencies getInstance() {
        if (currenciesInstance == null) {
            synchronized (Currencies.class) {
                if (currenciesInstance == null)
                    currenciesInstance = new Currencies();
            }
        }
        return currenciesInstance;
    }


    /**
     * Creates new object of Currency, and adds it to the database.
     * @param currencyId is the currency id which has to be 3 characters like "USD".
     * @param currencyName is the currency name, and it can have spaces and numbers
     * @param valueInUSD is the equivalent value in US Dollar currency.
     * @throws Exception if any of the given argument is not as expected.
     * @throws Exception if the database has already the currency because each currency will be added once.
     */
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


    /**
     * Returns the Currency object using the currencyId which is the key in our database.
     * @param currencyId This is the currency id which must be three characters like "USD"
     * @return the Currency object if there is any.
     * @throws Exception if any of the given argument is not as expected.
     * @throws Exception if there is no such a currency in database.
     */
    public Currency getCurrency(final String currencyId) throws Exception {
        if (currencyId == null || currencyId.length() != 3) {
            throw new Exception("Bad currencyId (Null or not 3 characters). currencyId must be 3 characters!");
        }
        String currencyIdUpperCase = currencyId.toUpperCase();
        if (!currenciesDatabase.containsKey(currencyIdUpperCase))
            throw new Exception("The currency " + currencyIdUpperCase + " does not exist!");
        return currenciesDatabase.get(currencyIdUpperCase);
    }


    /**
     * Returns a list of currencies in database.
     * @return a list of the values of database which are all existing Currency objects.
     */
    public List<Currency> getDatabase() {
        return new ArrayList<>(currenciesDatabase.values());
    }
}
