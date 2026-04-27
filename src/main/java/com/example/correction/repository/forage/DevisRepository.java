package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.Devis;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Integer>{
    
    @Query("SELECT COUNT(d.id) FROM Devis d")
    int getNbrDevisTotal();

    @Query("SELECT d FROM Devis d WHERE d.demande.id = :idDemande")
    List<Devis> findByDemande(@Param("idDemande") int idDemande);
}
