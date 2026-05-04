package com.example.correction.repository.forage;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.correction.entity.forage.HoraireTravail;

public interface HoraireTravailRepository extends JpaRepository<HoraireTravail, Integer>{
    HoraireTravail findByJourSemaineAndActifTrue(int jourSemaine);
}
