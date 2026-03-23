package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Devis;
import com.example.correction.repository.forage.DevisRepository;

@Service
public class DevisService {
    @Autowired
    private DevisRepository devisRepository;

    public List<Devis> findAll(){
        return devisRepository.findAll();
    }

    public Devis findById(int id){
        return devisRepository.findById(id).orElse(null);
    }

    public Devis save(Devis devis){
        return devisRepository.save(devis);
    }

    public void deleteById(int id){
        devisRepository.deleteById(id);
    }
}
