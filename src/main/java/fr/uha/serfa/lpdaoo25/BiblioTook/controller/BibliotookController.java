package fr.uha.serfa.lpdaoo25.BiblioTook.controller;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Autheur;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BibliotookController {


    @GetMapping("/bibliotook/autheur")
    public Autheur basicAutheur(){
        return new Autheur();
    }


    @GetMapping("/bibliotook/livre")
    public Livre basicLivre(){
        return new Livre();
    }

}
