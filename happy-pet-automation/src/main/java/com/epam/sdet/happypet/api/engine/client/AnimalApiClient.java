package com.epam.sdet.happypet.api.engine.client;

import com.epam.sdet.happypet.api.data.models.response.AnimalResponse;
import com.epam.sdet.happypet.api.engine.IRestResponse;
import com.epam.sdet.happypet.api.engine.RestResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

@BasePath(path = "/animals/")
public class AnimalApiClient extends BaseApiClient<AnimalApiClient, AnimalResponse, AnimalResponse> {

    public AnimalApiClient(RequestSpecification specification) {
        super(specification);
    }

    public AnimalApiClient() {
        super();
    }

    @Override
    public IRestResponse<AnimalResponse> getEntityById(int id) {
        Response response = given().spec(requestSpecification)
                .get(basePath.concat("{id}"), id);
        return new RestResponse(AnimalResponse.class, response, "item");
    }

    @Override
    public IRestResponse<AnimalResponse> createEntity(AnimalResponse request) {
       throw new UnsupportedOperationException("The method is not implemented yet");
    }

    @Override
    public Response deleteEntity(int id) {
        throw new UnsupportedOperationException("The method is not implemented yet");
    }

}