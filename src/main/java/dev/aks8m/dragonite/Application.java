package dev.aks8m.dragonite;

import net.tcgdex.sdk.TCGdex;
import net.tcgdex.sdk.models.Card;
import net.tcgdex.sdk.models.SetResume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        TCGdex tcGdex = new TCGdex("en");
        SetResume[] sets =  tcGdex.fetchSets();

        Card card = tcGdex.fetchCard("swsh3-136");
        System.out.println("break");
    }
}
