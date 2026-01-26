package dev.aks8m.dragonite.tcg.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TCGDexSet(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("logo") String logo) {
}
