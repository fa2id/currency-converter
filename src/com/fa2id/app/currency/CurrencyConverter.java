package com.fa2id.app.currency;

/**
 * This is an interface for converting a currency to another currency.
 *
 * @author farid
 * www.fa2id.com
 */
public interface CurrencyConverter {

    /**
     * This method converts an amount from a currency to another currency.
     *
     * @param amount         is the amount of money which has to be converted.
     * @param fromCurrencyId is the currency ID of the amount you want to convert from.
     *                       Must be three characters like "USD".
     * @param toCurrencyId   is the currency ID of the amount you want to convert to.
     *                       Must be three characters like "USD".
     * @return the converted value,
     * @throws Exception if any of the arguments has an unexpected format
     */
    double convert(double amount, String fromCurrencyId, String toCurrencyId) throws Exception;
}
