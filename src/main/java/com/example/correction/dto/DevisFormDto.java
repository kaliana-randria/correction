package com.example.correction.dto;

import java.util.List;

import com.example.correction.entity.forage.DevisDetails;

public class DevisFormDto {
    private int idDemande;
    private int idTypeDevis;
    private List<DevisDetails> details;
    
    public int getIdDemande() {
        return idDemande;
    }
    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }
    public int getIdTypeDevis() {
        return idTypeDevis;
    }
    public void setIdTypeDevis(int idTypeDevis) {
        this.idTypeDevis = idTypeDevis;
    }
    public List<DevisDetails> getDetails() {
        return details;
    }
    public void setDetails(List<DevisDetails> details) {
        this.details = details;
    }
}
