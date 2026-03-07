package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Operateur;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Integer>{
}
