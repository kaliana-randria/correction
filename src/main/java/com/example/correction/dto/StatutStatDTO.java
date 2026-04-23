package com.example.correction.dto;

public class StatutStatDTO {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String libelle;
    private Long total;
    

    public StatutStatDTO(int id, String libelle, Long total) {
        this.id = id;
        this.libelle = libelle;
        this.total = total;
    }
    public StatutStatDTO(String libelle, Long total) {
        this.libelle = libelle;
        this.total = total;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    
}
