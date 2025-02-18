package fr.uha.serfa.lpdaoo25.BiblioTook.dao;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsagerRepository extends JpaRepository<Usager, Long> {

    public Usager getById(Long id);

    Set<Usager> findDistinctByEmpruntNotNull();
}
