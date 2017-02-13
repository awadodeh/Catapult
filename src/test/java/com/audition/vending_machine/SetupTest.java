package com.audition.vending_machine;

import com.audition.exception.InvalidCoinTypeException;
import com.audition.model.Coin;
import com.audition.model.CoinType;
import com.audition.model.Product;
import com.audition.service.vendingMachine.VendingMachine;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Awad on 2/13/17.
 */
public class SetupTest {

    public VendingMachine vendingMachine;
    List<CoinType> validCoinTypes;
    List<Product> productList;


    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
//        addValidCoinTypes();
        addProductsList();

    }


//    public void addValidCoinTypes(){
//        validCoinTypes = new ArrayList<CoinType>();
//        validCoinTypes.add(CoinType.NICKEL);
//        validCoinTypes.add(CoinType.DIME);
//        validCoinTypes.add(CoinType.QUARTER);
//
//        vendingMachine = new VendingMachine(validCoinTypes);
//    }

    public void addProductsList(){

        /**
         * cola for $1.00, chips for $0.50, and candy for $0.65
         */

        productList = new ArrayList<Product>();

        Product product1 = new Product("1","cola",1.00);
        Product product2 = new Product("2","chips",0.50);
        Product product3 = new Product("3","candy",0.65);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        vendingMachine.setProductList(productList);
    }

}
