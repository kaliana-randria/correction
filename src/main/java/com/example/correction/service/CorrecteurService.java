package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Correcteur;
import com.example.correction.repository.CorrecteurRepository;

@Service
public class CorrecteurService {
    @Autowired
    private CorrecteurRepository correcteurRepository;

    public List<Correcteur> findAll() {
        return correcteurRepository.findAll();
    }

    public Correcteur findById(int id) {
        return correcteurRepository.findById(id).orElse(null);
    }

    public Correcteur save(Correcteur correcteur) {
        return correcteurRepository.save(correcteur);
    }

    public void deleteById(int id) {
        correcteurRepository.deleteById(id);
    }
}
