package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * représente un livre
 * un livre est rédigé par UN auteur
 */
@Entity
public class Livre {
    @Id @GeneratedValue
    private Long id;

    private String titre = "50 nuances de Grey";
    private String ISBN = "1083KZH9D";
    private LocalDate datePublication = LocalDate.of(2012,04,03);

    @ManyToOne
    @JoinColumn(name = "author_ID")
    private Auteur auteur = new Auteur();

    public Livre() {
        this.auteur.addLivre(this);
    }

    public Livre(String titre, String ISBN, LocalDate datePublication, Auteur auteur) {
        this.titre = titre;
        this.ISBN = ISBN;
        this.datePublication = datePublication;
        this.auteur = auteur;
        this.auteur.addLivre(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public String getTitre() {
        return titre;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur a) {
        this.auteur = a;
        a.addLivre(this);
    }
}
