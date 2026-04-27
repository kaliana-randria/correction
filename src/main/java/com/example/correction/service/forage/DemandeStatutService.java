package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Demande;
import com.example.correction.entity.forage.DemandeStatut;
import com.example.correction.entity.forage.Statut;
import com.example.correction.repository.forage.DemandeRepository;
import com.example.correction.repository.forage.DemandeStatutRepository;
import com.example.correction.repository.forage.StatutRepository;

@Service
public class DemandeStatutService {
    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private StatutRepository statutRepository;

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

    public List<DemandeStatut> getStatutDemandeActuel(){
        return demandeStatutRepository.getStatutActuelPourDemandes();
    }

    public List<DemandeStatut> getParDemande(int idDemande){
        return demandeStatutRepository.findByDemandeId(idDemande);
    }

    public DemandeStatut saveDemandeStatut(DemandeStatut demandeStatut) {

        Demande demande = demandeRepository.findById(demandeStatut.getDemande().getId())
            .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
    
        Statut statut = statutRepository.findById(demandeStatut.getStatut().getId())
                .orElseThrow(() -> new RuntimeException("Statut non trouvé"));

        DemandeStatut ds = new DemandeStatut();
        ds.setDemande(demande);
        ds.setStatut(statut);
        ds.setDate(demandeStatut.getDate());
        ds.setObservation(demandeStatut.getObservation());

        return demandeStatutRepository.save(ds);
    }

    public List<DemandeStatut> findByDemande(int idDemande){
        return demandeStatutRepository.findByDemande(idDemande);
    }

    public List<DemandeStatut> findByStatut(int idStatut){
        return demandeStatutRepository.findByStatut(idStatut);
    }
    
}
