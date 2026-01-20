package dev.aks8m.dragonite.tcg;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TCGDexClient {

    private final RestClient client;

    public TCGDexClient(RestClient.Builder builder) {
        this.client = builder
                .baseUrl("https://api.tcgdex.net/v2/en")
                .build();
    }

    public void sets() {

    }

    public void series() {

    }

    public void cards() {

    }

    public RestClient get() {
        return client;
    }
}
