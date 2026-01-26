package dev.aks8m.dragonite.tcg.external;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class TCGDexClient {

    private final RestClient client;

    public TCGDexClient(RestClient.Builder builder) {
        this.client = builder
                .baseUrl("https://api.tcgdex.net/v2/en")
                .build();
    }

    public List<TCGDexSet>  sets() {
        TCGDexSet[] sets = client.get().uri("/sets")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("TCGDex: /sets resource not found");})
                .toEntity(TCGDexSet[].class)
                .getBody();
        return sets != null ? List.of(sets) : List.of();
    }

    public List<TCGDexSeries> series() {
        TCGDexSeries[] series = client.get().uri("/series")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("TCGDex: /series resource not found");})
                .toEntity(TCGDexSeries[].class)
                .getBody();
        return series != null ? List.of(series) : List.of();
    }

    public void cards() {

    }

    public RestClient get() {
        return client;
    }
}
