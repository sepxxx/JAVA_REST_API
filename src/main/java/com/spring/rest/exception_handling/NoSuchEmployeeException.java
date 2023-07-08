package com.spring.rest.exception_handling;

public class NoSuchEmployeeException extends Exception{
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
