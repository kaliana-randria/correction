package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer>{

    @Query("SELECT d FROM Demande d WHERE d.client.id = :idClient")
    List<Demande> findDemandeByIdClient(@Param("idClient") int idClient);
}