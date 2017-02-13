package com.audition.service.vendingMachine;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.model.Product;
import com.audition.state.*;

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
    private List<Product> productList;

    private double currentAmount;


    /**
     * Hardcoding initialized lists
     */
    public VendingMachine(){

        validCoinsTypeInit();
        productsInit();
        statesInit();

        coinReturnList = new ArrayList<Coin>();
        this.state = getNoCoinsState();

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


    public void selectProduct(Product product){

        if(currentAmount != 0){
            state = hasCoinsState;
        }
        state.selectProduct(product);

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }



    private void validCoinsTypeInit(){
        validCoinTypes = new ArrayList<CoinType>();
        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);
    }


    private void productsInit(){

        productList = new ArrayList<Product>();

        Product product1 = new Product("1","cola",1.00);
        Product product2 = new Product("2","chips",0.50);
        Product product3 = new Product("3","candy",0.65);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

    }


    private void statesInit() {

        noCoinsState = new NoCoinsState(this);
        hasCoinsState = new HasCoinsState(this);
//        soldOutState = new SoldOutState(this);
//        soldState = new SoldState(this);



    }


    public State getNoCoinsState() {
        return noCoinsState;
    }

    public void setNoCoinsState(State noCoinsState) {
        this.noCoinsState = noCoinsState;
    }

    public State getHasCoinsState() {
        return hasCoinsState;
    }

    public void setHasCoinsState(State hasCoinsState) {
        this.hasCoinsState = hasCoinsState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }
}
