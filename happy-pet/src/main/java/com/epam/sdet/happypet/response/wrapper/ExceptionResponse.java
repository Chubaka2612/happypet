package com.epam.sdet.happypet.response.wrapper;

import com.epam.sdet.happypet.util.ResponseCode;

import java.util.Objects;

public class ExceptionResponse {

    private ResponseCode responseCode;

    private String details;

    public ExceptionResponse(ResponseCode code, String details) {
        this.responseCode = code;
        this.details = details;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExceptionResponse that = (ExceptionResponse) o;
        return responseCode.equals(that.responseCode) &&
                details.equals(that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseCode, details);
    }
}