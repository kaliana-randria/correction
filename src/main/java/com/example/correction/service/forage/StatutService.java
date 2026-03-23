package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Statut;
import com.example.correction.repository.forage.StatutRepository;

@Service
public class StatutService {
    @Autowired
    private StatutRepository statutRepository;

    public List<Statut> findAll(){
        return statutRepository.findAll();
    }

    public Statut findById(int id){
        return statutRepository.findById(id).orElse(null);
    }

    public Statut save(Statut statut){
        return statutRepository.save(statut);
    }

    public void deleteById(int id){
        statutRepository.deleteById(id);
    }
}
