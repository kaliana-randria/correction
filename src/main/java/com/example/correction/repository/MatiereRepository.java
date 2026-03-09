package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer>{
}
