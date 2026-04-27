package com.example.correction.repository.forage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
    @Query("SELECT COUNT(c.id) FROM Client c")
    int getNbrClient();
}
