package fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AuteurInscriptionDTO extends AuteurConexionDTO {

    public LocalDate naissance;

    public String matchingPassword;
}