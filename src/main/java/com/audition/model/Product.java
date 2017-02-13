package com.audition.model;

/**
 * Created by Awad on 2/9/17.
 */
public class Product {

    private String productID;
    private String productName;
    private double productPrice;


    public Product() {

        this.productID ="0";
        this.productName="Empty";
        this.productPrice = 0;
    }

    public Product(String productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
