package com.audition.model;

/**
 * Created by Awad on 2/9/17.
 */
public class Coin {

    private CoinType coinType;

    public Coin(CoinType coinType) {
        this.coinType = coinType;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public void setCoinType(CoinType coinType) {
        this.coinType = coinType;
    }

}
