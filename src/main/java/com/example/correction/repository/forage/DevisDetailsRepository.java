package com.example.correction.repository.forage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.forage.Devis;
import com.example.correction.entity.forage.DevisDetails;

@Repository
public interface DevisDetailsRepository extends JpaRepository<DevisDetails, Integer>{
    List<DevisDetails> findByDevis(Devis devis);

    @Query("SELECT SUM(d.qtte * d.PU) FROM DevisDetails d")
    double getMontantDevisTotal();

    @Query("SELECT dd FROM DevisDetails dd WHERE dd.devis.id = :idDevis")
    List<DevisDetails> findDetailsByDevis(@Param("idDevis") int idDevis);

}
