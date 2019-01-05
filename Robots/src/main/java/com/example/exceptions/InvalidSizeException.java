package com.example.exceptions;

public class InvalidSizeException extends Exception{

    public InvalidSizeException() {
    }

    public InvalidSizeException(String message) {
        super(message);
    }
}
