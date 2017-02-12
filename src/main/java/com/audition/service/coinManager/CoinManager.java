package com.audition.service.coinManager;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;

/**
 * Created by Awad on 2/10/17.
 */
public interface CoinManager {

    double insertCoin(Coin coin) throws InvalidCoinTypeException;

    double getCurrentAmount();


}
