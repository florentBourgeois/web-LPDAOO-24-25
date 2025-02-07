package fr.uha.serfa.lpdaoo25.BiblioTook.controller;

import fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto.AuteurSecurise;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Auteur;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Bibliotheque;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;
import fr.uha.serfa.lpdaoo25.BiblioTook.utils.BibliothequeFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class BibliotookController {


    @GetMapping("/bibliotook/autheur")
    public Auteur basicAutheur(){
        return new Auteur();
    }

    @GetMapping("/bibliotook/autheurLivre")
    public AuteurSecurise autheurAvecLivre(){
        Auteur a = new Auteur();
        Livre l = new Livre("encore 50 nuances de gray", "OASJ", LocalDate.now(), a);
        a.addLivre(l);
        return new AuteurSecurise(a);
    }


    @GetMapping("/bibliotook/livre")
    public Livre basicLivre(){
        return new Livre();
    }

    @GetMapping("/bibliotook/bibliotheque")
    public Bibliotheque basicBibliotheque(){
        return new Bibliotheque();
    }

    @GetMapping("/bibliotook/bibliothequeBig")
    public Bibliotheque bigBibliotheque(){
        return BibliothequeFactory.getBigBibliotheque();
    }

}
