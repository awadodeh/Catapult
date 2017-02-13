package com.audition.insert_coin_tests.positive_tests;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.service.vendingMachine.VendingMachine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awad on 2/10/17.
 */

public class InsertCoinsPositiveTest {

    VendingMachine vendingMachine;
    List<CoinType> validCoinTypes;


    @Before
    public void setUp(){
        validCoinTypes = new ArrayList<CoinType>();
        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);

        vendingMachine = new VendingMachine(validCoinTypes);

    }

    @Test
    public void insertDimeCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.DIME);

        vendingMachine.insertCoin(coin);

        double expected = vendingMachine.getCurrentAmount();
        double actual = coin.getCoinType().getValue();

        assertEquals(actual,expected,0);

    }

    @Test
    public void insertNickelCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.NICKEL);

        vendingMachine.insertCoin(coin);

        double expected = vendingMachine.getCurrentAmount();
        double actual = coin.getCoinType().getValue();

        assertEquals(actual,expected,0);

    }


    @Test
    public void insertQuarterCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.QUARTER);

        vendingMachine.insertCoin(coin);

        double expected = vendingMachine.getCurrentAmount();
        double actual = coin.getCoinType().getValue();

        assertEquals(actual,expected,0);

    }

    @After
    public void cleanUp(){

        vendingMachine.setCurrentAmount(0);
        double actual = vendingMachine.getCurrentAmount();

        assertEquals(0,actual,0);

    }
}
