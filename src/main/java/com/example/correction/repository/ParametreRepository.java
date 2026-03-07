package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Parametre;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Integer> {
}
