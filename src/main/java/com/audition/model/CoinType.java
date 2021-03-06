package com.audition.model;

/**
 * Created by Awad on 2/9/17.
 */
public enum CoinType {

    PENNIE(0.01),
    NICKEL(0.05),
    DIME(0.1),
    QUARTER(0.25);
    
    private double value;
    
    CoinType(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
