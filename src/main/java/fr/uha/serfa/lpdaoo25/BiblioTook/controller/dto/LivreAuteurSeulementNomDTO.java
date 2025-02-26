package fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;

import java.time.LocalDate;

public record LivreAuteurSeulementNomDTO(String titre, String ISBN, LocalDate datePublication, String auteur) {

    public static LivreAuteurSeulementNomDTO fromLivre(Livre l){
        String auteurNom = l.getAuteur().getPrenom() + " "+ l.getAuteur().getNom();
        return new LivreAuteurSeulementNomDTO(l.getTitre(), l.getISBN(), l.getDatePublication(), auteurNom);
    }

}
