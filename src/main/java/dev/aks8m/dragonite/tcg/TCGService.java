package dev.aks8m.dragonite.tcg;

import dev.aks8m.dragonite.tcg.external.TCGDexClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.desktop.SystemSleepEvent;

@Service
public class TCGService {

    private final TCGDexClient tcgDexClient;

    @Autowired
    public TCGService(TCGDexClient tcgDexClient) {
        this.tcgDexClient = tcgDexClient;
    }

    public void getPokemonSeries() {

        var series = tcgDexClient.series();
        var sets = tcgDexClient.sets();

        System.out.println("break");
    }
}
