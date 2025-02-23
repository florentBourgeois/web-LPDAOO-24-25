package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * représente un auteur de livre
 * un auteur a rédigé des livres
 */
@Entity
public class Auteur extends Utilisateur{
    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livre> livres = new ArrayList<>();
    public String password = "monPass";

    public Auteur() {
    }

    public Auteur(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public List<Livre> getLivres() {
        return livres;
    }

    public void addLivre(Livre l){
        this.livres.add(l);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                ((id == null) ? "" : id)  +
                ", " + nom +  " " + prenom +
                ", " + password +
                '}';
    }
}
