package com.example.correction.entity.forage;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "demande_statut")
public class DemandeStatut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_demande", nullable = false)
    private Demande demande;

    @ManyToOne
    @JoinColumn(name = "id_statut", nullable = false)
    private Statut statut;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "observation")
    private String observation;

    @Column(name = "duree_total")
    private int dureeTotal;

    @Column(name = "duree_travaille")
    private int dureeTravaille;

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDureeTotal() {
        return dureeTotal;
    }

    public void setDureeTotal(int dureeTotal) {
        this.dureeTotal = dureeTotal;
    }

    public int getDureeTravaille() {
        return dureeTravaille;
    }

    public void setDureeTravaille(int dureeTravaille) {
        this.dureeTravaille = dureeTravaille;
    }

}
