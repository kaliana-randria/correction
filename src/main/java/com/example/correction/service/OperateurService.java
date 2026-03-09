package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Operateur;
import com.example.correction.repository.OperateurRepository;

@Service
public class OperateurService {
    @Autowired
    private OperateurRepository operateurRepository;

    public List<Operateur> findAll() {
        return operateurRepository.findAll();
    }

    public Operateur findById(int id) {
        return operateurRepository.findById(id).orElse(null);
    }

    public Operateur save(Operateur operateur) {
        return operateurRepository.save(operateur);
    }

    public void deleteById(int id) {
        operateurRepository.deleteById(id);
    }
}
