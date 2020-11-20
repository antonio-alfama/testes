package com.school.mindera.exceptions;

public class CustomException extends Exception {

    public CustomException() {
        super("This is a custom exception");
    }

    public CustomException(String file) {
        super("This file was not found " + file);
    }

}
