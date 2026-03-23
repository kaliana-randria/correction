package com.example.correction.service.forage;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.correction.entity.forage.Demande;
import com.example.correction.entity.forage.DemandeStatut;
import com.example.correction.entity.forage.Statut;
import com.example.correction.repository.forage.DemandeRepository;

@Service
public class DemandeService {
    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private StatutService statutService;

    @Autowired
    private DemandeStatutService demandeStatutService;

    public List<Demande> findAll(){
        return demandeRepository.findAll();
    }

    public Demande findById(int id){
        return demandeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Demande save(Demande demande){
        Demande creerDemande = demandeRepository.save(demande);

        Statut statut = statutService.findById(1);
        DemandeStatut demandeStatut = new DemandeStatut();
        demandeStatut.setDemande(creerDemande);
        demandeStatut.setStatut(statut);
        demandeStatut.setDate(LocalDateTime.now());

        demandeStatutService.save(demandeStatut);

        return creerDemande;
    }

    public void deleteById(int id){
        demandeRepository.deleteById(id);
    }
}
