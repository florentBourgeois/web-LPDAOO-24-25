package fr.uha.serfa.lpdaoo25.BiblioTook.dao;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Auteur;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {


    Optional<Auteur> findByNomAndPrenom(String nom, String prenom);
}
