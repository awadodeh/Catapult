package com.audition.insert_coin_tests.positive_tests;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.service.coinManager.CoinManager;
import com.audition.service.coinManager.CoinManagerImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awad on 2/10/17.
 */

public class InsertCoinsPositiveTest {

    CoinManager coinManager;
    List<CoinType> validCoinTypes;


    @Before
    public void setUp(){
        validCoinTypes = new ArrayList<CoinType>();
        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);

        coinManager = new CoinManagerImpl(validCoinTypes);

    }

    @Test
    public void insertDimeCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.DIME);

        double expected = coinManager.insertCoin(coin);
        double actual = coin.getCoinType().getValue();

        assertEquals(actual,expected,0);

    }

    @Test
    public void insertNickelCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.NICKEL);

        double expected = coinManager.insertCoin(coin);
        double actual = coin.getCoinType().getValue();

        assertEquals(actual,expected,0);

    }


    @Test
    public void insertQuarterCoinTest() throws InvalidCoinTypeException {

        Coin coin = new Coin(CoinType.QUARTER);

        double expected = coinManager.insertCoin(coin);
        double actual = coin.getCoinType().getValue();

        assertEquals(actual,expected,0);

    }
}
