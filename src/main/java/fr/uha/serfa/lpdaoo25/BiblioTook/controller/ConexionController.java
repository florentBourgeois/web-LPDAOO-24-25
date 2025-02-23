package fr.uha.serfa.lpdaoo25.BiblioTook.controller;

import fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto.AuteurConexionDTO;
import fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto.AuteurInscriptionDTO;
import fr.uha.serfa.lpdaoo25.BiblioTook.dao.AuteurRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Auteur;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/securite")
public class ConexionController {

    private AuteurRepository auteurRepository;
    private PasswordEncoder passwordEncoder;

    public ConexionController(AuteurRepository auteurRepository, PasswordEncoder passwordEncoder) {
        this.auteurRepository = auteurRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/infoSecretes")
    public List<Auteur> tousLesAuteurs() {
        return auteurRepository.findAll();
    }

    @PostMapping("/creation")
    ResponseEntity<?> createAuteur(@Valid @RequestBody AuteurInscriptionDTO auteurInscription) {
        if(! auteurInscription.password.equals(auteurInscription.matchingPassword))
            return ResponseEntity.badRequest().body(new MessageResponse("Les mots de passe ne correspondent pas"));

        Optional<Auteur> auteurOptional = auteurRepository.findByNomAndPrenom(auteurInscription.nom, auteurInscription.prenom);
        if(auteurOptional.isPresent()) // l'auteur existe déja -> on ne peut pas le créer
            return ResponseEntity.badRequest().body(new MessageResponse("Un auteur est déja nommé comme cela"));

        Auteur auteur = new Auteur(auteurInscription.nom, auteurInscription.prenom, auteurInscription.naissance);

        // approche à revoir. On ne veut pas stocker le mot de passe en clair
        //auteur.setPassword(auteurInscription.password);
        String passwordEncoded = passwordEncoder.encode(auteurInscription.password);
        auteur.setPassword(passwordEncoded);

        auteurRepository.save(auteur);
        return ResponseEntity.ok(auteur);
    }

    @PostMapping("/conexion")
    ResponseEntity<?> connectAuteur(@Valid @RequestBody AuteurConexionDTO auteurConexion) {
        Optional<Auteur> auteurOptional = auteurRepository.findByNomAndPrenom(auteurConexion.nom, auteurConexion.prenom);
        if(! auteurOptional.isPresent()) // l'auteur existe déja -> on ne peut pas le créer
            return ResponseEntity.badRequest().body(new MessageResponse("Auteur inconnu"));

        Auteur auteur = auteurOptional.get();
        if(! passwordEncoder.matches(auteurConexion.password, auteur.getPassword()))
            return ResponseEntity.badRequest().body(new MessageResponse("Le mot de passe est incorrect"));

        return ResponseEntity.ok(new MessageResponse("Bienvenue " + auteur.getNom()));
    }


    record MessageResponse(String message) {}

}

