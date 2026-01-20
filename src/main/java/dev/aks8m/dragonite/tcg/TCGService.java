package dev.aks8m.dragonite.tcg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TCGService {

    private final TCGDexClient tcgDexClient;

    @Autowired
    public TCGService(TCGDexClient tcgDexClient) {
        this.tcgDexClient = tcgDexClient;
    }

    public void getPokemonSeries() {
        tcgDexClient.get().get().uri("/sets").retrieve();
    }
}
