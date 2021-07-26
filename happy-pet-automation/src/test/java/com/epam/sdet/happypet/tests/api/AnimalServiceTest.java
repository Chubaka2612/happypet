package com.epam.sdet.happypet.tests.api;

import com.epam.sdet.happypet.api.data.HttpStatusCode;
import com.epam.sdet.happypet.api.engine.Api;
import com.epam.sdet.happypet.api.engine.IRestResponse;
import com.epam.sdet.happypet.api.engine.client.AnimalApiClient;
import com.epam.sdet.happypet.core.common.asserts.AssertHelper;
import org.junit.jupiter.api.Test;

public class AnimalServiceTest extends  BaseApiTest{

    @Test
    public void VerifyGetAnimal_ExistingId()  {

        AnimalApiClient animalApiClient = Api.getClient(AnimalApiClient.class);

        AssertHelper.isTrue(animalApiClient.getEntityById(10)
                .getBody()
                .getName()
                .equals("Kiriusha"), "Verify animal is present by existing id");
    }

    @Test
    public void VerifyGetAnimal_NotExistingId()  {

        int notExistingId = 101;
        AnimalApiClient animalApiClient = Api.getClient(AnimalApiClient.class);

        IRestResponse response = animalApiClient.getEntityById(notExistingId);

        AssertHelper.assertAll( "Verify animal is not present by not existing id",
                () -> AssertHelper.isTrue(response
                        .getStatusCode()
                        .equals(HttpStatusCode.NOT_FOUND),
                        "Verify status code is correct"),
                () -> AssertHelper.isTrue(response.getContent().contains("Can't find animal with id: " + notExistingId),
                        "Verify correct message is present in response"));
    }
}