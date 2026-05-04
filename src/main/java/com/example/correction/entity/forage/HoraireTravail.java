package com.example.correction.entity.forage;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="horaire_travail")
public class HoraireTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "jour_semaine")
    private int jourSemaine;

    @Column(name = "debut_matin")
    private LocalTime debutMatin;

    @Column(name = "fin_matin")
    private LocalTime finMatin;

    @Column(name = "debut_aprem")
    private LocalTime debutAprem;

    @Column(name = "fin_aprem")
    private LocalTime finAprem;

    @Column(name = "actif")
    private Boolean actif;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(int jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public LocalTime getDebutMatin() {
        return debutMatin;
    }

    public void setDebutMatin(LocalTime debutMatin) {
        this.debutMatin = debutMatin;
    }

    public LocalTime getFinMatin() {
        return finMatin;
    }

    public void setFinMatin(LocalTime finMatin) {
        this.finMatin = finMatin;
    }

    public LocalTime getDebutAprem() {
        return debutAprem;
    }

    public void setDebutAprem(LocalTime debutAprem) {
        this.debutAprem = debutAprem;
    }

    public LocalTime getFinAprem() {
        return finAprem;
    }

    public void setFinAprem(LocalTime finAprem) {
        this.finAprem = finAprem;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
}
