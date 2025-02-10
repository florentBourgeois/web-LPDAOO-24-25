package fr.uha.serfa.lpdaoo25.BiblioTook.dao;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository extends JpaRepository<Usager, Long> {



}
