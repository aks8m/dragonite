package dev.aks8m.dragonite.tcg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TCGController {

    private final TCGService tcgService;

    @Autowired
    public TCGController(TCGService tcgService) {
        this.tcgService = tcgService;
    }

    @GetMapping("/tcg")
    public String getTCGPage() {
        tcgService.getPokemonSeries();
        return "tcg";
    }

}
