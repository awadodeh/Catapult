package com.audition.service.validator;

import com.audition.model.CoinType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awad on 2/10/17.
 */
public class CoinValidator {

    List<CoinType> validCoinTypes;


    public CoinValidator() {

        validCoinTypes = new ArrayList<CoinType>();
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.QUARTER);

    }

    public CoinValidator(List<CoinType> validCoinTypes) {
        this.validCoinTypes = validCoinTypes;
    }

    public boolean isCoinValid(CoinType coinType){
        return validCoinTypes.contains(coinType);
    }
}
