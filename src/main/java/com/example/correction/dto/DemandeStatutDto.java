package com.example.correction.dto;

import com.example.correction.entity.forage.DemandeStatut;

public class DemandeStatutDto {
    private DemandeStatut demandeStatut;
    private String level;

    public DemandeStatut getDemandeStatut() {
        return demandeStatut;
    }

    public void setDemandeStatut(DemandeStatut demandeStatut) {
        this.demandeStatut = demandeStatut;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
