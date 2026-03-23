package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Demande;
import com.example.correction.repository.forage.DemandeRepository;

@Service
public class DemandeService {
    @Autowired
    private DemandeRepository demandeRepository;

    public List<Demande> findAll(){
        return demandeRepository.findAll();
    }

    public Demande findById(int id){
        return demandeRepository.findById(id).orElse(null);
    }

    public Demande save(Demande demande){
        return demandeRepository.save(demande);
    }

    public void deleteById(int id){
        demandeRepository.deleteById(id);
    }
}
