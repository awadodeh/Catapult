package com.audition.Driver;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.service.vendingMachine.VendingMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awad on 2/12/17.
 */
public class Driver {


    public static void main(String[] args) throws InvalidCoinTypeException {


        Driver driver = new Driver();

        driver.setUp();

        System.out.println(""+driver.insertDimeCoinTest());
        System.out.println(""+driver.insertNickelCoinTest());
        System.out.println(""+driver.insertQuarterCoinTest());


    }

    VendingMachine vendingMachine;
    List<CoinType> validCoinTypes;


    public void setUp(){
        validCoinTypes = new ArrayList<CoinType>();
        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);

        vendingMachine = new VendingMachine(validCoinTypes);

    }

    public double insertDimeCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.DIME);

        vendingMachine.insertCoin(coin);
        double expected = vendingMachine.getCurrentAmount();

        double actual = coin.getCoinType().getValue();

        return expected - actual;
    }

    public double insertNickelCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.NICKEL);

        double expected = vendingMachine.insertCoin(coin);
        double actual = coin.getCoinType().getValue();

        return expected - actual;

    }


    public double insertQuarterCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.QUARTER);

        double expected = vendingMachine.insertCoin(coin);
        double actual = coin.getCoinType().getValue();

        return expected - actual;

    }
}
