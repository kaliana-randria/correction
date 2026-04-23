package com.example.correction.repository.forage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.TypeDevis;

@Repository
public interface TypeDevisRepository extends JpaRepository<TypeDevis, Integer>{

    @Query("SELECT COUNT(td.id) FROM TypeDevis td")
    int getNbrDevis();
}