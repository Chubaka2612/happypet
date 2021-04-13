package com.epam.sdet.happypet.exception;

public class CreateException extends RuntimeException {

    public CreateException(String errorMessage) {
        super(errorMessage);
    }
}