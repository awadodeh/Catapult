package com.audition.service.vendingMachine;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.state.NoCoinsState;
import com.audition.state.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awad on 2/12/17.
 */
public class VendingMachine {

    private State noCoinsState;
    private State hasCoinsState;
    private State soldState;
    private State soldOutState;

    private State state;

    private List<CoinType> validCoinTypes;

    private List<Coin> coinsList;

    private List<Coin> coinReturnList;

    private double currentAmount;


    public VendingMachine(){

        validCoinTypes = new ArrayList<CoinType>();
        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);

        coinReturnList = new ArrayList<Coin>();

        this.state = new NoCoinsState(this);

        currentAmount = 0;

    }

    public VendingMachine(List<CoinType> validCoinTypes) {
        this.validCoinTypes = validCoinTypes;

        coinsList = new ArrayList<Coin>();
        coinReturnList = new ArrayList<Coin>();

        this.state = new NoCoinsState(this);

        currentAmount = 0;
    }



    public double insertCoin(Coin coin) {

        try {
            currentAmount = state.insertCoins(coin);
        } catch (InvalidCoinTypeException e) {
            e.printStackTrace();
        }

        return currentAmount;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public List<Coin> getCoinReturnList() {
        return coinReturnList;
    }

    public void addToCoinReturnList(Coin coin) {
        this.coinReturnList.add(coin);
    }
}
