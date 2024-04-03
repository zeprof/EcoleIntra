package org.example.dao;

import org.example.modele.Prof;
import org.example.service.dto.ProfDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfRepository extends JpaRepository<Prof, Long> {

    @Query("""
        select p from Prof p
        left join fetch p.cours c
        left join fetch c.etudiants
        where lower(p.nomProf) = lower(:name)
        """)
    Optional<Prof> findByNomProf(@Param("name") String prof);
}
