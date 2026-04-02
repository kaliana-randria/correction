package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.Devis;
import com.example.correction.entity.forage.DevisDetails;

@Repository
public interface DevisDetailsRepository extends JpaRepository<DevisDetails, Integer>{
    List<DevisDetails> findByDevis(Devis devis);
}
