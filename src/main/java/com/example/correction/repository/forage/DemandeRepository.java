package com.example.correction.repository.forage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer>{
}