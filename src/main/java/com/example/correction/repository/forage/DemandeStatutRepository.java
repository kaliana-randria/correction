package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.DemandeStatut;

@Repository
public interface DemandeStatutRepository extends JpaRepository<DemandeStatut, Integer>{
    @Query("""
        SELECT ds
        FROM DemandeStatut ds
        WHERE ds.id = (
            SELECT MAX(ds2.id)
            FROM DemandeStatut ds2
            WHERE ds2.demande.id = ds.demande.id
        )
    """)
    List<DemandeStatut> getStatutActuelPourDemandes();

    List<DemandeStatut> findByDemandeId(int idDemande);
}