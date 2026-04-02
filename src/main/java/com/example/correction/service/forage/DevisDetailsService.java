package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Devis;
import com.example.correction.entity.forage.DevisDetails;
import com.example.correction.repository.forage.DevisDetailsRepository;

@Service
public class DevisDetailsService {
    @Autowired
    private DevisDetailsRepository devisDetailsRepository;

    public List<DevisDetails> findAll(){
        return devisDetailsRepository.findAll();
    }

    public DevisDetails findById(int id){
        return devisDetailsRepository.findById(id).orElse(null);
    }

    public DevisDetails save(DevisDetails devisDetails){
        return devisDetailsRepository.save(devisDetails);
    }

    public void deleteById(int id){
        devisDetailsRepository.deleteById(id);
    }

    public List<DevisDetails> findByDevis(Devis devis){
        return devisDetailsRepository.findByDevis(devis);
    }
}
