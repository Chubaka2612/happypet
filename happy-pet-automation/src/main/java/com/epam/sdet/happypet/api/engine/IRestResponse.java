package com.epam.sdet.happypet.api.engine;

import com.epam.sdet.happypet.api.data.HttpStatusCode;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public interface IRestResponse <T> {

    T getBody();

    String getContent();

    String getContentLength();

    String getContentType();

    HttpStatusCode getStatusCode();

    boolean isSuccessful();

    String getStatusDescription();

    Response getResponse();

    Exception getException();
}