package com.example.correction.entity.forage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "indicateur")
public class Indicateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_statut1", nullable = false)
    private Statut statut1;

    @ManyToOne
    @JoinColumn(name = "id_statut2", nullable = false)
    private Statut statut2;

    @Column(name = "interval1")
    private int interval1;

    @Column(name = "interval2")
    private int interval2;

    @ManyToOne
    @JoinColumn(name = "level")
    private Level level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Statut getStatut1() {
        return statut1;
    }

    public void setStatut1(Statut statut1) {
        this.statut1 = statut1;
    }

    public Statut getStatut2() {
        return statut2;
    }

    public void setStatut2(Statut statut2) {
        this.statut2 = statut2;
    }

    public int getInterval1() {
        return interval1;
    }

    public void setInterval1(int interval1) {
        this.interval1 = interval1;
    }

    public int getInterval2() {
        return interval2;
    }

    public void setInterval2(int interval2) {
        this.interval2 = interval2;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
