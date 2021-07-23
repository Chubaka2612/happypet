package com.epam.sdet.happypet.api.engine;

import com.epam.sdet.happypet.api.engine.client.BaseApiClient;

public final class Api {

    private Api() {

    }

    public static <TClient extends BaseApiClient> TClient getClient(Class<TClient> client) {
        try {
            return client.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(String.format("Client can't be represented as %s", client.getName()), e);
        }
    }
}
