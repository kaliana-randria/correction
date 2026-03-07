package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Correcteur;

@Repository
public interface CorrecteurRepository extends JpaRepository<Correcteur, Integer> {
}
