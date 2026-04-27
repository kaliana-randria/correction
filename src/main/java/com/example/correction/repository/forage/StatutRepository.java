package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.correction.dto.StatutStatDTO;
import com.example.correction.entity.forage.Statut;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Integer>{

    // @Query("SELECT s.id as id, s.libelle, COUNT(ds.id) " +
    //     "FROM DemandeStatut ds " +
    //     "JOIN ds.statut s " +
    //     "GROUP BY s.id, s.libelle")
    // List<StatutStatDTO> getStatParStatut();

    @Query("""
    SELECT new com.example.correction.dto.StatutStatDTO(
        s.id,
        s.libelle,
        COUNT(ds.id)
    )
    FROM DemandeStatut ds
    JOIN ds.statut s
    GROUP BY s.id, s.libelle
    """)
    List<StatutStatDTO> getStatParStatut();

}
