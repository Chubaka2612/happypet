package com.epam.sdet.happypet.api.engine;

import com.epam.sdet.happypet.api.data.HttpStatusCode;
import io.restassured.response.Response;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

public class RestResponse<T> implements IRestResponse<T> {

    private String wrapperPath;

    private T data;

    private Response response;

    private Exception e;

    public RestResponse(Class<T> t, Response response, String ... wrapperPath) {
        if(wrapperPath.length > 0) {
            this.wrapperPath = wrapperPath[0];
        }
        this.response = response;
        try {
            this.data = t.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Can't instantiate a new object");
        }
    }

    public String getContent() {
        return response.getBody().asString();
    }

    public String getContentLength() {
        return response.headers().getValue("Content-Length");
    }

    public String getContentType() {
        return response.headers().getValue("Content-Type");
    }

    public HttpStatusCode getStatusCode() {
        return EnumUtils.getEnumList(HttpStatusCode.class).stream()
                .filter(code -> code.getCode() == response.getStatusCode()).findFirst().get();
    }

    public boolean isSuccessful() {
        HttpStatusCode code = getStatusCode();
        return (code.equals(HttpStatusCode.OK) ||
                code.equals(HttpStatusCode.CREATED) ||
                code.equals(HttpStatusCode.ACCEPTED) ||
                code.equals(HttpStatusCode.NON_AUTHORITATIVE_INFORMATION) ||
                code.equals(HttpStatusCode.NO_CONTENT) ||
                code.equals(HttpStatusCode.RESET_CONTENT));
    }

    public String getStatusDescription() {
        return response.getStatusLine();
    }

    public Response getResponse() {
        return response;
    }

    public T getBody() {
        try {
            if (StringUtils.isBlank(wrapperPath)) {
                data = (T) response.getBody().as(data.getClass());
            } else {
                data = (T) response.getBody().jsonPath().getObject(wrapperPath, data.getClass());
            }

        } catch (Exception e) {
            this.e = e;
        }
        return data;
    }

    public Exception getException() {
        return e;
    }
}