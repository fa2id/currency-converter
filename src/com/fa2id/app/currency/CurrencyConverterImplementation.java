package com.fa2id.app.currency;

import java.text.DecimalFormat;

/**
 * This is a Currency Conversion Implementation which is for converting an amount from a currency to another currency.
 *
 * @author farid
 * www.fa2id.com
 */
public class CurrencyConverterImplementation implements CurrencyConverter {

    /**
     * This method converts an amount from a currency to another currency. It uses database to retrieve currencies.
     *
     * @param amount         is the amount of money which has to be converted.
     * @param fromCurrencyId is the currency ID of the amount you want to convert from.
     *                       Must be three characters like :USD".
     * @param toCurrencyId   is the currency ID of the amount you want to convert to.
     *                       Must be three characters like "USD".
     * @return the converted value.
     * @throws RuntimeException if any of the arguments has an unexpected format.
     */
    @Override
    public double convert(final double amount, final String fromCurrencyId, final String toCurrencyId) {
        if (fromCurrencyId == null || fromCurrencyId.length() != 3) {
            throw new RuntimeException("Bad convertFromId (Null or not 3 characters). convertFromId must be 3 characters! " +
                    "convertFromId= " + fromCurrencyId);
        }
        if (toCurrencyId == null || toCurrencyId.length() != 3) {
            throw new RuntimeException("Bad convertToId (Null or not 3 characters). convertToId must be 3 characters! " +
                    "convertToId= " + toCurrencyId);
        }
        final String fromIdUpperCase = fromCurrencyId.toUpperCase();
        final String toIdUpperCase = toCurrencyId.toUpperCase();
        final DecimalFormat decimalFormat = new DecimalFormat("#.######");
        final double formattedAmount = Double.valueOf(decimalFormat.format(amount));
        Currencies currencies = Currencies.getInstance();
        final Currency fromCurrency = currencies.getCurrency(fromIdUpperCase);
        final Currency toCurrency = currencies.getCurrency(toIdUpperCase);
        final double fromValueInUSD = fromCurrency.getValueInUSD();
        final double toValueInUSD = toCurrency.getValueInUSD();
        final double convertedAmount = convertAmount(formattedAmount, fromValueInUSD, toValueInUSD);
        return Double.valueOf(decimalFormat.format(convertedAmount));
    }


    /**
     * This method is a helper method to calculate and convert the value.
     *
     * @param amount         is the amount to be converted.
     * @param fromValueInUSD is the USD value of the original currency.
     * @param toValueInUSD   is the USD value of the desired currency to be converted to.
     * @return a double which is the converted value.
     */
    private double convertAmount(final double amount, final double fromValueInUSD, final double toValueInUSD) {
        final double convertedAmount = (amount * fromValueInUSD) / toValueInUSD;
        final DecimalFormat decimalFormat = new DecimalFormat("#.######");
        return Double.valueOf(decimalFormat.format(convertedAmount));
    }
}
