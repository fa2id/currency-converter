package com.fa2id.app.currency;

/**
 * @author farid
 * www.fa2id.com
 */
public class Currency {

    private final String id;
    private final String name;
    private final double valueInUSD;

    public Currency(String id, String name, double valueInUSD) {
        this.id = id;
        this.name = name;
        this.valueInUSD = valueInUSD;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getValueInUSD() {
        return valueInUSD;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", valueInUSD=" + valueInUSD +
                '}';
    }
}
