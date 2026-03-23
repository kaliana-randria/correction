package com.example.correction.repository.forage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.DevisDetails;

@Repository
public interface DevisDetailsRepository extends JpaRepository<DevisDetails, Integer>{
    
}
