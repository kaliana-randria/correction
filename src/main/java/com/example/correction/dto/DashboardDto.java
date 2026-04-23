package com.example.correction.dto;

import java.util.List;

public class DashboardDto {
    private double chiffreAffaire;
    private long nbrClient;
    private long nbrDevis;

    private List<StatutStatDTO> statuts;

    public DashboardDto(double chiffreAffaire, long nbrClient, long nbrDevis, List<StatutStatDTO> statuts) {
        this.chiffreAffaire = chiffreAffaire;
        this.nbrClient = nbrClient;
        this.nbrDevis = nbrDevis;
        this.statuts = statuts;
    }

    public DashboardDto() {
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public long getNbrClient() {
        return nbrClient;
    }

    public void setNbrClient(long nbrClient) {
        this.nbrClient = nbrClient;
    }

    public long getNbrDevis() {
        return nbrDevis;
    }

    public void setNbrDevis(long nbrDevis) {
        this.nbrDevis = nbrDevis;
    }

    public List<StatutStatDTO> getStatuts() {
        return statuts;
    }

    public void setStatuts(List<StatutStatDTO> statuts) {
        this.statuts = statuts;
    }
}
