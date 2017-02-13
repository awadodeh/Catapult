package com.audition.state;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.model.Product;
import com.audition.service.validator.CoinValidator;
import com.audition.service.vendingMachine.VendingMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awad on 2/12/17.
 */
public class NoCoinsState implements State{

    VendingMachine vendingMachine;

    CoinValidator coinValidator;

    public NoCoinsState() {

        vendingMachine = new VendingMachine();

        List<CoinType> validCoinTypes = new ArrayList();
        validCoinTypes.add(CoinType.NICKEL);
        validCoinTypes.add(CoinType.DIME);
        validCoinTypes.add(CoinType.QUARTER);

        coinValidator = new CoinValidator(validCoinTypes);

    }

    public NoCoinsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        coinValidator = new CoinValidator();
    }

    public double insertCoins(Coin coin) throws InvalidCoinTypeException {

        double currentAmount;
        if(coinValidator.isCoinValid(coin.getCoinType())){

            currentAmount = vendingMachine.getCurrentAmount()+coin.getCoinType().getValue();


            vendingMachine.setCurrentAmount(currentAmount);

        }else{
            vendingMachine.addToCoinReturnList(coin);
            throw new InvalidCoinTypeException();
        }

        return currentAmount;
    }


    public void selectProduct(Product product) {

//        System.out.println("You need to pay first");
        System.out.println(product.getProductName() + "'s Price is: " + product.getProductPrice());

    }

    public void returnCoins() {
        System.out.println("You need to pay first");
    }
}
