package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Parametre;
import com.example.correction.repository.ParametreRepository;

@Service
public class ParametreService {
    @Autowired
    private ParametreRepository parametreRepository;

    public List<Parametre> findAll() {
        return parametreRepository.findAll();
    }

    public Parametre findById(int id) {
        return parametreRepository.findById(id).orElse(null);
    }

    public Parametre save(Parametre parametre) {
        return parametreRepository.save(parametre);
    }

    public void deleteById(int id) {
        parametreRepository.deleteById(id);
    }

    public List<Parametre> findByMatiereId(int matiereId) {
        return parametreRepository.findByMatiereId(matiereId);
    }
}
