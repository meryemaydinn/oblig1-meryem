package com.example.oblig1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class Oblig1Controller {
    @Autowired
    private Oblig1Repository rep;

    @PostMapping("/billett")
    public void lagreBillet(Oblig1 billett) {
        rep.lagreBillet(billett);
    }

    @GetMapping("/billetter")
    public List<Oblig1> hentAlleBilletter() {
        return  rep.hentAlleBilletter();
    }

    @GetMapping("/slettBillett")
    public void slecttAlleBilletter() {
        rep.slettAlleBilletter();
    }
}












