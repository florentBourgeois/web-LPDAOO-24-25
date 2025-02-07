package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Autheur {

    private String nom = "James";
    private String prenom = "Erika Leonard";
    private LocalDate naissance = LocalDate.of(1963, 03, 07);
    private List<Livre> livres = new ArrayList<>();
    public String password = "monPass";

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

    public List<Livre> getLivres() {
        return livres;
    }

    public void addLivre(Livre l){
        this.livres.add(l);
    }
}
