package com.example.correction.entity.forage;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ChiffreAffaireTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "montant_global_devis_total", nullable = false)
    private double montantDevisTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontantDevisTotal() {
        return montantDevisTotal;
    }

    public void setMontantDevisTotal(double montantDevisTotal) {
        this.montantDevisTotal = montantDevisTotal;
    }

    
}
