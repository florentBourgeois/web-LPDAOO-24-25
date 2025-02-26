package fr.uha.serfa.lpdaoo25.BiblioTook.dao;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {



    @Query("SELECT l FROM Livre l LEFT JOIN Usager u on u.emprunt.id = l.id WHERE u.id IS NULL")
    List<Livre> findAllDispo();

    @Query("SELECT l FROM Livre l RIGHT JOIN Usager u on u.emprunt.id = l.id")
    List<Livre> findAllEmprunt();

    //List<NomLivreDTO> getAll();



}
