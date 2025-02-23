package fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AuteurConexionDTO {

    @NotNull
    @NotEmpty
    public String nom;

    @NotNull
    @NotEmpty
    public String prenom;

    @NotNull
    @NotEmpty
    public String password;

}