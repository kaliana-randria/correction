package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Candidat;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer>{
}
