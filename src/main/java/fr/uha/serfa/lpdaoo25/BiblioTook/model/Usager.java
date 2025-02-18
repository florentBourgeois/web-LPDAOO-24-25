package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usager {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate naissance;

    @ElementCollection
    private List<Address> adresses = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Livre emprunt;

    public Livre getEmprunt() {
        return emprunt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usager(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public Usager() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
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

    public int getNbrLivresEmprunt() {
        return 0;
    }


    @Override
    public String toString() {
        return "Usager{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", naissance=" + naissance +
                '}';
    }
}
