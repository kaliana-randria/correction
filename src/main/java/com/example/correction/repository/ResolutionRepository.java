package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Resolution;

@Repository
public interface ResolutionRepository extends JpaRepository<Resolution, Integer>{
}
