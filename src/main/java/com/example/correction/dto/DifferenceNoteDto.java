package com.example.correction.dto;

public class DifferenceNoteDto {
    private int correcteur1;
    private double note1;

    private int correcteur2;
    private double note2;

    private double difference;

    public DifferenceNoteDto(int correcteur1, double note1, int correcteur2, double note2, double difference) {
        this.correcteur1 = correcteur1;
        this.note1 = note1;
        this.correcteur2 = correcteur2;
        this.note2 = note2;
        this.difference = difference;
    }

    public int getCorrecteur1() {
        return correcteur1;
    }

    public void setCorrecteur1(int correcteur1) {
        this.correcteur1 = correcteur1;
    }

    public double getNote1() {
        return note1;
    }

    public void setNote1(double note1) {
        this.note1 = note1;
    }

    public int getCorrecteur2() {
        return correcteur2;
    }

    public void setCorrecteur2(int correcteur2) {
        this.correcteur2 = correcteur2;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    

}
