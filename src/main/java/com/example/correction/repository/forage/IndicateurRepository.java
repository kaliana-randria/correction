package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.Indicateur;

@Repository
public interface IndicateurRepository extends JpaRepository<Indicateur, Integer> {
    List<Indicateur> findByStatut1IdAndStatut2Id(int idS1, int idS2);
}
