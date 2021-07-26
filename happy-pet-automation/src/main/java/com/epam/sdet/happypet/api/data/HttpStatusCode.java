package com.epam.sdet.happypet.api.data;

public enum HttpStatusCode {

    CONTINUE (100),

    OK (200),

    CREATED (201),

    ACCEPTED (202),

    NON_AUTHORITATIVE_INFORMATION (203),

    NO_CONTENT(204),

    RESET_CONTENT(205),

    PARTIAL_CONTENT(206),

    MOVED (301),

    FOUND (302),

    BAD_REQUEST (400),

    UNAUTHORIZED (401),

    FORBIDDEN (403),

    NOT_FOUND (404),

    METHOD_NOT_ALLOWED (405),

    INTERNAL_SERVER_ERROR (500),

    NOT_IMPLEMENTED (501),

    BAD_GATEWAY (502),

    GATEWAY_TIMEOUT (504);

    private final int code;

    HttpStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
