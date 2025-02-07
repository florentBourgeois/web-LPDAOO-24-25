package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import java.time.LocalDate;

public class Autheur {

    private String nom = "James";
    private String prenom = "Erika Leonard";
    private LocalDate naissance = LocalDate.of(1963, 03, 07);

    public Autheur() {
    }

    public Autheur(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return naissance;
    }
}
