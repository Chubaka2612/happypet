package com.epam.sdet.happypet.util;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResponseCode {

    INTERNAL_SERVER_ERROR(5000, "Internal Server Error"),
    NOT_FOUND_ERROR(4000, "Not Found Error"),
    VALIDATION_FAILED_ERROR(4000, "Validation Error"),
    SUCCESS(2000, "Success"),
    CREATED(2001, "Created");

    private final int code;
    private final String codeMessage;

    ResponseCode(int code, String codeMessage) {
        this.code = code;
        this.codeMessage = codeMessage;
    }

    public int getCode() {
        return code;
    }

    public String getCodeMessage() {
        return codeMessage;
    }
}