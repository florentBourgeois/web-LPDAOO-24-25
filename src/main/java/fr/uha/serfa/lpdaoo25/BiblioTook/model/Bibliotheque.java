package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {

    private String adresse = "10 rue de la gare Mulhouse";
    private String nom = "Bibliothèque municipale";
    private List<Livre> livres = new ArrayList<>();

    public Bibliotheque() {
        livres.add(new Livre());
        livres.add(new Livre("Jardinage 2024", "1028347SHCI", LocalDate.now(), new Autheur("Florent", "Bourgeois", LocalDate.now())));

    }

    public Bibliotheque(String adresse, String nom, List<Livre> livres) {
        this.adresse = adresse;
        this.nom = nom;
        this.livres = livres;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public List<Livre> getLivres() {
        return livres;
    }


}
