package com.audition.service.coinManager.validator;

import com.audition.model.CoinType;
import com.audition.service.coinManager.CoinManagerImpl;

/**
 * Created by Awad on 2/10/17.
 */
public class CoinValidator {

    private CoinManagerImpl coinManager;

    public CoinValidator(CoinManagerImpl coinManager) {
        this.coinManager = coinManager;
    }

    public boolean isCoinValid(CoinType coinType){
            if(coinManager.getValidCoinTypes().contains(coinType)) {
                return true;
            }else {
                return false;
            }
    }
}
