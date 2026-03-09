package com.example.correction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.dto.DifferenceNoteDto;
import com.example.correction.entity.Note;
import com.example.correction.repository.NoteRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note findById(int id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(int id) {
        noteRepository.deleteById(id);
    }


    public List<DifferenceNoteDto> calculerDifferences(int candidatId, int matiereId) {
        List<Note> notes = noteRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);

        List<DifferenceNoteDto> resultats = new ArrayList<>();

        for (int i = 0; i < notes.size(); i++) {
            for (int j = i + 1; j < notes.size(); j++) {
                Note n1 = notes.get(i);
                Note n2 = notes.get(j);

                double diff = Math.abs(n1.getValeur() - n2.getValeur());

                resultats.add(new DifferenceNoteDto(
                        n1.getCorrecteur().getId(),
                        n1.getValeur(),
                        n2.getCorrecteur().getId(),
                        n2.getValeur(),
                        diff
                ));
            }
        }

        return resultats;
    }

    public double calculSommeDifferenceValiny(List<DifferenceNoteDto> differences) {
        double valiny = 0;

        for (DifferenceNoteDto diff : differences) {
            valiny += diff.getDifference();
        }

        return valiny;
    }

    public double calculMoyenneNote(int candidatId, int matiereId){
        List<Note> notes = noteRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);
        double moyenne = 0;
        double somme = 0;

        for (Note note : notes) {
            somme += note.getValeur();
        }

        if(notes.isEmpty()){
            return 0;
        }
        
        moyenne = somme / notes.size();

        return moyenne;
    }

}
