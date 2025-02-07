package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bibliotheque {

    private String adresse = "10 rue de la gare Mulhouse";
    private String nom = "Bibliothèque municipale";
    private List<Livre> livres = new ArrayList<>();

    public Bibliotheque() {
        livres.add(new Livre());
        livres.add(new Livre("Jardinage 2024", "1028347SHCI", LocalDate.now(), new Auteur("Florent", "Bourgeois", LocalDate.now())));

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

    public Set<Auteur> tousLesAuteurs(){
        Set<Auteur> auteurs = new HashSet<>();
        for (Livre l : this.livres){
            auteurs.add(l.getAuteur());
        }
        return auteurs;
    }

    public Set<Auteur> auteurParNom(String nomRecherche){
        Set<Auteur> auteursQuiMatchent = new HashSet<>();
        for (Auteur a : this.tousLesAuteurs()){
            if(a.getNom().contains(nomRecherche)){
                auteursQuiMatchent.add(a);
            }
        }
        return  auteursQuiMatchent;
    }


}
