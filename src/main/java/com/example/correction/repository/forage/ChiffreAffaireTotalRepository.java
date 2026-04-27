package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.ChiffreAffaireTotal;

@Repository
public interface ChiffreAffaireTotalRepository extends JpaRepository<ChiffreAffaireTotal, Integer>{
    ChiffreAffaireTotal findTopByOrderByIdDesc();

    @Query("""
            SELECT td.libelle, SUM(dd.PU * dd.qtte)
            FROM Devis d
            JOIN d.typeDevis td
            JOIN DevisDetails dd ON dd.devis = d
            GROUP BY td.libelle
        """)
    List<Object[]> getChiffreAffaireByType();
}
