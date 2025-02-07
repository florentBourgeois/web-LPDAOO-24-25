package fr.uha.serfa.lpdaoo25.BiblioTook.controller;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Autheur;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutheurSecurise {

    public String nom = "James";
    public String prenom = "Erika Leonard";
    public LocalDate dateNaissance = LocalDate.of(1963, 03, 07);
    public List<Livre> livres = new ArrayList<>();

    public AutheurSecurise(Autheur a){
        this.nom = a.getNom();
        this.dateNaissance = a.getDateNaissance();
        this.prenom = a.getPrenom();
        this.livres = a.getLivres();
    }

}
