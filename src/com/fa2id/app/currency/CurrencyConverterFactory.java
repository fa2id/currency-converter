package com.fa2id.app.currency;

/**
 * This is the factory class for Currency Converter.
 *
 * @author Farid Ariafard
 * www.fa2id.com
 */
public class CurrencyConverterFactory {


    /**
     * This method creates CurrencyConverter object.
     *
     * @return CurrencyConverter object
     */
    public static CurrencyConverter create() {
        return new CurrencyConverterImplementation();
    }
}
