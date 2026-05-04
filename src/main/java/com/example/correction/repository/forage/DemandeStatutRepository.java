package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT ds FROM DemandeStatut ds WHERE ds.demande.id = :idDemande ORDER BY ds.date DESC")
    List<DemandeStatut> findByDemande(@Param("idDemande") int idDemande);

    @Query("SELECT ds FROM DemandeStatut ds WHERE ds.statut.id = :id")
    List<DemandeStatut> findByStatut(@Param("id") int id);

    @Query("""
        SELECT ds
        FROM DemandeStatut ds
        WHERE ds.demande.id = :idDemande
        ORDER BY ds.date DESC
    """)
    List<DemandeStatut> findLastByDemande(@Param("idDemande") int idDemande);

    @Query("SELECT ds FROM DemandeStatut ds WHERE ds.demande.id = :idDemande ORDER BY ds.date ASC")
    List<DemandeStatut> findByDemandeOrderByDateAsc(@Param("idDemande") int idDemande);
}