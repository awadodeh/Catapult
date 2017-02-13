package com.audition.state;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.Product;
import com.audition.service.vendingMachine.VendingMachine;

/**
 * Created by Awad on 2/12/17.
 */
public class HasCoinsState implements State{

    VendingMachine vendingMachine;

    public HasCoinsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public double insertCoins(Coin coin) throws InvalidCoinTypeException {
        return 0;
    }

    public void selectProduct(Product product) {

        double currentAmount =  vendingMachine.getCurrentAmount();
        double amountNeeded = currentAmount - product.getProductPrice();

        if(amountNeeded >=0 ){

            dispense(product);

            vendingMachine.setCurrentAmount(amountNeeded);

            System.out.println("Thank You!");

        }else{
            if(currentAmount!=0){
                System.out.println("The current amount is: " + vendingMachine.getCurrentAmount());
            }else{
                System.out.println("INSERT COIN!");
            }
        }

    }

    public void returnCoins() {


    }

    public void dispense(Product product) {

        System.out.println("Product: " + product.getProductName() + " is dispensed");

    }
}
