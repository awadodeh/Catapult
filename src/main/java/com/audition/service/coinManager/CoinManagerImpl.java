package com.audition.service.coinManager;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.service.coinManager.validator.CoinValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awad on 2/10/17.
 */
public class CoinManagerImpl implements CoinManager{

    private List<CoinType> validCoinTypes;

    private List<Coin> coinsList;

    private List<Coin> coinRetrunList;

    private double currentAmount;


    public CoinManagerImpl() {
    }

    public CoinManagerImpl(List<CoinType> validCoinTypes) {
        this.validCoinTypes = validCoinTypes;

        coinsList = new ArrayList<Coin>();
        coinRetrunList = new ArrayList<Coin>();

        currentAmount = 0;


    }

    public List<CoinType> getValidCoinTypes() {
        return validCoinTypes;
    }

    public void setValidCoinTypes(List<CoinType> validCoinTypes) {
        this.validCoinTypes = validCoinTypes;
    }

    public List<Coin> getCoinsList() {
        return coinsList;
    }

    public void setCoinsList(List<Coin> coinsList) {
        this.coinsList = coinsList;
    }


    public double insertCoin(Coin coin) throws InvalidCoinTypeException {
        CoinValidator coinValidator = new CoinValidator(this);

        if(coinValidator.isCoinValid(coin.getCoinType())){
            coinsList.add(coin);

            currentAmount += coin.getCoinType().getValue();

        }else{
            coinRetrunList.add(coin);
            throw new InvalidCoinTypeException();
        }

        return currentAmount;
    }

    public double getCurrentAmount() {

        return currentAmount;
    }
}
