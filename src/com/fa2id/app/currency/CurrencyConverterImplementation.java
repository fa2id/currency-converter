package com.fa2id.app.currency;

import java.text.DecimalFormat;

/**
 * @author farid
 * www.fa2id.com
 */
public class CurrencyConverterImplementation implements CurrencyConverter {

    @Override
    public double convert(final double amount, final String fromCurrencyId, final String toCurrencyId)
            throws Exception {
        if (fromCurrencyId == null || fromCurrencyId.length() != 3) {
            throw new Exception("Bad convertFromId (Null or not 3 characters). convertFromId must be 3 characters! " +
                    "convertFromId= " + fromCurrencyId);
        }
        if (toCurrencyId == null || toCurrencyId.length() != 3) {
            throw new Exception("Bad convertToId (Null or not 3 characters). convertToId must be 3 characters! " +
                    "convertToId= " + toCurrencyId);
        }
        final String fromIdUpperCase = fromCurrencyId.toUpperCase();
        final String toIdUpperCase = toCurrencyId.toUpperCase();
        final DecimalFormat decimalFormat = new DecimalFormat("#.##");
        final double formattedAmount = Double.valueOf(decimalFormat.format(amount));
        Currencies currencies = Currencies.getInstance();
        final Currency fromCurrency = currencies.getCurrency(fromIdUpperCase);
        final Currency toCurrency = currencies.getCurrency(toIdUpperCase);
        final double fromValueInUSD = fromCurrency.getValueInUSD();
        final double toValueInUSD = toCurrency.getValueInUSD();
        final double convertedAmount = convertAmount(formattedAmount, fromValueInUSD, toValueInUSD);
        return Double.valueOf(decimalFormat.format(convertedAmount));
    }

    private double convertAmount(final double amount, final double fromValueInUSD, final double toValueInUSD) {
        final double convertedAmount = (amount * fromValueInUSD) / toValueInUSD;
        final DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.valueOf(decimalFormat.format(convertedAmount));
    }
}
