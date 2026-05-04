package com.example.correction.service.forage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.dto.DevisFormDto;
import com.example.correction.entity.forage.Demande;
import com.example.correction.entity.forage.DemandeStatut;
import com.example.correction.entity.forage.Devis;
import com.example.correction.entity.forage.DevisDetails;
import com.example.correction.entity.forage.Statut;
import com.example.correction.entity.forage.TypeDevis;
import com.example.correction.repository.forage.DemandeRepository;
import com.example.correction.repository.forage.DemandeStatutRepository;
import com.example.correction.repository.forage.DevisRepository;
import com.example.correction.repository.forage.StatutRepository;
import com.example.correction.repository.forage.TypeDevisRepository;

import jakarta.transaction.Transactional;

@Service
public class DevisService {
    @Autowired
    private DevisRepository devisRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private TypeDevisRepository typeDevisRepository;

    @Autowired
    private DevisDetailsService devisDetailsService;

    @Autowired
    private StatutRepository statutRepository;

    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    @Autowired
    private DureeService dureeService;

    public List<Devis> findAll() {
        return devisRepository.findAll();
    }

    public Devis findById(int id) {
        return devisRepository.findById(id).orElse(null);
    }

    public Devis save(Devis devis) {
        return devisRepository.save(devis);
    }

    public void deleteById(int id) {
        devisRepository.deleteById(id);
    }

    @Transactional
    public void creationDevis(DevisFormDto form) {

        Demande demande = demandeRepository.findById(form.getIdDemande())
                .orElseThrow(() -> new RuntimeException("Demande introuvable"));

        TypeDevis type = typeDevisRepository.findById(form.getIdTypeDevis())
                .orElseThrow(() -> new RuntimeException("Type devis introuvable"));

        Devis devis = new Devis();
        devis.setDemande(demande);
        devis.setTypeDevis(type);
        devis.setDate(LocalDateTime.now());

        devisRepository.save(devis);

        for (DevisDetails d : form.getDetails()) {
            d.setDevis(devis);
            devisDetailsService.save(d);
        }

        // int statutId = (form.getIdTypeDevis() == 1) ? 2 : 3;

        int statutId;

        if (form.getIdTypeDevis() == 1) {
            statutId = 2;
        } else {
            statutId = 3;
        }

        Statut statut = statutRepository.findById(statutId)
                .orElseThrow();

        // DemandeStatut ds = new DemandeStatut();
        // ds.setDemande(demande);
        // ds.setStatut(statut);
        // ds.setDate(LocalDateTime.now());

        // demandeStatutRepository.save(ds);

        List<DemandeStatut> historiques = demandeStatutRepository.findByDemande(demande.getId());

        LocalDateTime now = LocalDateTime.now();

        DemandeStatut nouveau = new DemandeStatut();
        nouveau.setDemande(demande);
        nouveau.setStatut(statut);
        nouveau.setDate(now);

        if (!historiques.isEmpty()) {

            DemandeStatut precedent = historiques.get(0);

            Duration dureeTotal = dureeService.calculDureeTsotra(precedent.getDate(), now);
            nouveau.setDureeTotal(dureeService.calculerHeuresArrondies(dureeTotal));

            Duration dureeTravaille = dureeService.calculDureeSarotra(precedent.getDate(), now);
            nouveau.setDureeTravaille(dureeService.calculerHeuresArrondies(dureeTravaille));

        } else {
            nouveau.setDureeTotal(0);
            nouveau.setDureeTravaille(0);
        }

        demandeStatutRepository.save(nouveau);
    }

    public List<Devis> findByDemande(int idDemande) {
        return devisRepository.findByDemande(idDemande);
    }
}
