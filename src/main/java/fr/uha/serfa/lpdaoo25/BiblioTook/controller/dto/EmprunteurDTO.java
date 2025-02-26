package fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto;


import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmprunteurDTO(Long id, String nom, String prenom, LocalDate naissance, long id_Emprunt, String titre_Emprunt) {

    public static EmprunteurDTO fromUsager(Usager u){
        return new EmprunteurDTO(u.getId(), u.getNom(), u.getPrenom(), u.getNaissance(), u.getEmprunt().getId(), u.getEmprunt().getTitre());
    }


}