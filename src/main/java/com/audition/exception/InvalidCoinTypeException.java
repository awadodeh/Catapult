package com.audition.exception;

/**
 * Created by Awad on 2/10/17.
 */
public class InvalidCoinTypeException extends Exception{

    public InvalidCoinTypeException(String message) {
        super(message);
    }

    public InvalidCoinTypeException() {

        this("Not Valid coin type, Insert a valid coins type!(Nickle, Dime, Quarter)");

    }
}
