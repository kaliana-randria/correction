package com.example.correction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Parametre;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Integer> {
    List<Parametre> findByMatiereId(int matiereId);
}
