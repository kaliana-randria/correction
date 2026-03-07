package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
