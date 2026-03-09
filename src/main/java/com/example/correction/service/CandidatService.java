package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Candidat;
import com.example.correction.repository.CandidatRepository;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepositoryRepository;

    public List<Candidat> findAll() {
        return candidatRepositoryRepository.findAll();
    }

    public Candidat findById(int id) {
        return candidatRepositoryRepository.findById(id).orElse(null);
    }

    public Candidat save(Candidat candidat) {
        return candidatRepositoryRepository.save(candidat);
    }

    public void deleteById(int id) {
        candidatRepositoryRepository.deleteById(id);
    }
}
