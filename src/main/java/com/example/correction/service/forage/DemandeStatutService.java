package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.DemandeStatut;
import com.example.correction.repository.forage.DemandeStatutRepository;

@Service
public class DemandeStatutService {
    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    public List<DemandeStatut> findAll(){
        return demandeStatutRepository.findAll();
    }

    public DemandeStatut findById(int id){
        return demandeStatutRepository.findById(id).orElse(null);
    }

    public DemandeStatut save(DemandeStatut demandeStatut){
        return demandeStatutRepository.save(demandeStatut);
    }

    public void deleteById(int id){
        demandeStatutRepository.deleteById(id);
    }
}
