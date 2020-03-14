package com.example.jwt.exception;

public class NoTokenException extends Exception {

    public NoTokenException(){}

    public NoTokenException(String msg){
        super(msg);
    }
}
