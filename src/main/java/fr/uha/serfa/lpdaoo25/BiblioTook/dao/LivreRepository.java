package fr.uha.serfa.lpdaoo25.BiblioTook.dao;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {

}
