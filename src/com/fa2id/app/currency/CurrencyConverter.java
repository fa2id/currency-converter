package com.fa2id.app.currency;

/**
 * @author farid
 * www.fa2id.com
 */
public interface CurrencyConverter {

    double convert(double amount, String convertFromId, String convertToId) throws Exception;
}
