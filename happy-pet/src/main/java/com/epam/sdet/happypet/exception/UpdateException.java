package com.epam.sdet.happypet.exception;

public class UpdateException extends RuntimeException {

    public UpdateException(String errorMessage) {
        super(errorMessage);
    }
}