package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Matiere;
import com.example.correction.repository.MatiereRepository;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepository matiereRepository;

    public List<Matiere> findAll() {
        return matiereRepository.findAll();
    }

    public Matiere findById(int id) {
        return matiereRepository.findById(id).orElse(null);
    }

    public Matiere save(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public void deleteById(int id) {
        matiereRepository.deleteById(id);
    }
}
