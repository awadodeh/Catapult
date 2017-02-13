package com.audition.select_product.positive_tests;

import com.audition.model.CoinType;
import com.audition.model.Product;
import com.audition.vending_machine.SetupTest;
import org.junit.Test;
import java.util.List;

/**
 * Created by Awad on 2/13/17.
 */
public class SelectProductTest extends SetupTest{

    List<CoinType> validCoinTypes;


    @Test
    public void selectCola(){

        Product cola = new Product("1","cola",1.00);
        vendingMachine.setCurrentAmount(1);
        vendingMachine.selectProduct(cola);

    }

}
