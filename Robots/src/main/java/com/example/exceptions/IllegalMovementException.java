package com.example.exceptions;

public class IllegalMovementException extends Exception{

    public IllegalMovementException() {
    }

    public IllegalMovementException(String message) {
        super(message);
    }
}
