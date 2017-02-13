package com.audition.state;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.Product;

/**
 * Created by Awad on 2/12/17.
 */
public interface State {

    double insertCoins(Coin coin) throws InvalidCoinTypeException;
    void selectProduct(Product product);
    void returnCoins();
//    void checkExactChangeOnly();



}
