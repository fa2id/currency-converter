package com.fa2id.app.currency;

/**
 * This is the model of the currency.
 *
 * @author farid
 * www.fa2id.com
 */
public class Currency {

    /**
     * This is the identifier of the currency which must be three characters. (e.g. USD)
     */
    private final String id;

    /**
     * This is the currency name. (e.g. US Dollar)
     */
    private final String name;

    /**
     * This is the value of the currency in USD. (e.g. 0.76 CAD = 1 USD)
     */
    private final double valueInUSD;


    public Currency(String id, String name, double valueInUSD) {
        this.id = id;
        this.name = name;
        this.valueInUSD = valueInUSD;
    }


    /**
     * Returns the identifier of the currency. It is exactly three characters, like "USD".
     *
     * @return the currency identifier which is three characters (e.g. USD)
     */
    public String getId() {
        return id;
    }


    /**
     * Returns the name of the currency, like "US Dollar".
     *
     * @return the name of the currency
     */
    public String getName() {
        return name;
    }


    /**
     * This returns the value of the currency in US Dollar.
     *
     * @return the value of the currency in USD.
     */
    public double getValueInUSD() {
        return valueInUSD;
    }


    /**
     * This returns the currency information like id, name, and valueInUSD
     *
     * @return the currency information
     */
    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", valueInUSD=" + valueInUSD +
                '}';
    }
}
