package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Note;
import com.example.correction.entity.Parametre;

@Service
public class ComparaisonService {
    @Autowired
    private NoteService noteService;

    public boolean verifierCondition(double valiny, Parametre parametre) {

        double seuil = parametre.getSeuil();
        String operateur = parametre.getOperateur().getNom();

        if (operateur.equals(">")) {
            return valiny > seuil;
        }

        if (operateur.equals("<")) {
            return valiny < seuil;
        }

        if (operateur.equals(">=")) {
            return valiny >= seuil;
        }

        if (operateur.equals("<=")) {
            return valiny <= seuil;
        }

        throw new RuntimeException("Operateur inconnu : " + operateur);
    }

    public double noteFinalAzo(String resolution, List<Note> notes, int candidatId, int matiereId) {

        double moyenne = noteService.calculMoyenneNote(candidatId, matiereId);
        double noteAzo = 0;

        if (resolution.equals("plus petit")) {

            noteAzo = notes.get(0).getValeur();

            for (Note note : notes) {
                noteAzo = Math.min(noteAzo, note.getValeur());
            }

        } else if (resolution.equals("plus grand")) {

            noteAzo = notes.get(0).getValeur();

            for (Note note : notes) {
                noteAzo = Math.max(noteAzo, note.getValeur());
            }

        } else if (resolution.equals("moyenne")) {

            noteAzo = moyenne;
        }

        return noteAzo;
    }
}
