package com.epam.sdet.happypet.api.engine.client;

import com.epam.sdet.happypet.api.engine.IRestResponse;
import com.epam.sdet.happypet.core.properties.Props;
import com.epam.sdet.happypet.core.properties.names.EnvProps;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.params.CoreConnectionPNames;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public abstract class BaseApiClient<TClientType extends BaseApiClient, TRequestType, TResponseType> {

    private static final String BASE_URL = Props.getInstance().getString(EnvProps.UI_BASE_URL);

    protected RequestSpecification requestSpecification;
    protected String basePath;

    public BaseApiClient(RequestSpecification specification) {
        this.requestSpecification = specification;

        basePath = RestAssured.baseURI
                .concat(getEndpoint());
    }

    public BaseApiClient() {
        setRequestSpecification();
        basePath = RestAssured.baseURI
                .concat(getEndpoint());

    }

    private void setRequestSpecification() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
                setParam("http.connection.timeout",300000).
                setParam("http.socket.timeout",300000).
                setParam("http.connection-manager.timeout",300000));

        requestSpecification =
                given().log().all()
                        .header("X-XSRF-DISABLE", true)
                        .contentType(ContentType.JSON);
    }

    private String getEndpoint() {
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType parameterized = (ParameterizedType) superclass;
        Class<TClientType> clientType = (Class<TClientType>) parameterized.getActualTypeArguments()[0];
        return clientType.getAnnotation(BasePath.class).path();
    }

    public abstract IRestResponse<TResponseType> getEntityById(int id);

    public abstract IRestResponse<TResponseType> createEntity(TRequestType request);

    public abstract Response deleteEntity(int id);

}