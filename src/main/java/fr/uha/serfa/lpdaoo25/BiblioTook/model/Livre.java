package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import java.time.LocalDate;

public class Livre {
    private String titre = "50 nuances de Grey";
    private String ISBN = "1083KZH9D";
    private LocalDate datePublication = LocalDate.of(2012,04,03);
    private Autheur autheur = new Autheur();

    public Livre() {
    }

    public Livre(String titre, String ISBN, LocalDate datePublication, Autheur autheur) {
        this.titre = titre;
        this.ISBN = ISBN;
        this.datePublication = datePublication;
        this.autheur = autheur;
    }

    public String getTitre() {
        return titre;
    }

    public String getISBN() {
        return ISBN;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public Autheur getAutheur() {
        return autheur;
    }
}
