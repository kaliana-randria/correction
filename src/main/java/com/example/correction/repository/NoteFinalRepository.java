package com.example.correction.repository;

import com.example.correction.entity.NoteFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteFinalRepository extends JpaRepository<NoteFinal, Integer> {
}