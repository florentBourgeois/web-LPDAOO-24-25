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
public class Auteur {
    @Id @GeneratedValue
    private Long id;

    private String nom = "James";
    private String prenom = "Erika Leonard";
    private LocalDate naissance = LocalDate.of(1963, 03, 07);

    @OneToMany
    private List<Livre> livres = new ArrayList<>();
    public String password = "monPass";

    public Auteur() {
    }

    public Auteur(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    public void setNaissance(LocalDate naissance) {
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

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return naissance;
    }

    @JsonIgnore
    public List<Livre> getLivres() {
        return livres;
    }

    public void addLivre(Livre l){
        this.livres.add(l);
    }
}
