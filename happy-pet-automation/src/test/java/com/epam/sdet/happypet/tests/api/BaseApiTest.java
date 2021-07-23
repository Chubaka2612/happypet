package com.epam.sdet.happypet.tests.api;

import com.epam.sdet.happypet.api.engine.Api;
import com.epam.sdet.happypet.api.engine.client.AnimalApiClient;
import com.epam.sdet.happypet.core.properties.Props;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    protected static Props properties;

    @BeforeAll
    public static void oneTimeBaseSetup() throws InterruptedException {
        String env = "LOCAL";

        Props.init(env);
        properties = Props.getInstance();

        waitForServiceDeployment();
    }

    //TODO
    private static void waitForServiceDeployment() throws InterruptedException {
        AnimalApiClient animalApiClient = Api.getClient(AnimalApiClient.class);
        int i = 0;

        do {
            try {
                animalApiClient.getEntityById(1).getResponse();
                i = 5;
            } catch (Exception ex) {
                Thread.sleep(2000);
                i++;
            }
        } while (i < 5);
    }
}