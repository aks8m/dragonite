package dev.aks8m.dragonite.tcg.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TCGDexSetBrief() {
}
