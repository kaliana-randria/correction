package com.example.correction.service.forage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.dto.DemandeStatutDto;
import com.example.correction.entity.forage.Demande;
import com.example.correction.entity.forage.DemandeStatut;
import com.example.correction.entity.forage.Indicateur;
import com.example.correction.entity.forage.Level;
import com.example.correction.entity.forage.Statut;
import com.example.correction.repository.forage.DemandeRepository;
import com.example.correction.repository.forage.DemandeStatutRepository;
import com.example.correction.repository.forage.IndicateurRepository;
import com.example.correction.repository.forage.StatutRepository;

@Service
public class DemandeStatutService {
    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private StatutRepository statutRepository;

    @Autowired
    private DureeService dureeService;

    @Autowired
    private IndicateurRepository indicateurRepository;

    @Autowired
    private LevelService levelService;

    public List<DemandeStatut> findAll() {
        return demandeStatutRepository.findAll();
    }

    public DemandeStatut findById(int id) {
        return demandeStatutRepository.findById(id).orElse(null);
    }

    public DemandeStatut save(DemandeStatut demandeStatut) {
        return demandeStatutRepository.save(demandeStatut);
    }

    public DemandeStatut updateObservationDate(DemandeStatut demandeStatut) {
        DemandeStatut actuel = demandeStatutRepository.findById(demandeStatut.getId())
                .orElseThrow(() -> new RuntimeException("Statut non trouvé"));

        LocalDateTime ancienneDate = actuel.getDate();

        actuel.setObservation(demandeStatut.getObservation());
        actuel.setDate(demandeStatut.getDate());

        if (!ancienneDate.equals(demandeStatut.getDate())) {
            return recalculerTouteLaChaine(actuel);
        } else {
            return demandeStatutRepository.save(actuel);
        }
        // return demandeStatutRepository.save(demandeStatut);
    }

    private DemandeStatut recalculerTouteLaChaine(DemandeStatut cible) {
        List<DemandeStatut> listeComplete = demandeStatutRepository
                .findByDemandeOrderByDateAsc(cible.getDemande().getId());

        DemandeStatut objetMisAJour = null;

        for (int i = 0; i < listeComplete.size(); i++) {
            DemandeStatut courant = listeComplete.get(i);

            if (i == 0) {
                courant.setDureeTotal(0);
                courant.setDureeTravaille(0);
            } else {
                DemandeStatut precedent = listeComplete.get(i - 1);

                Duration dureeTotal = dureeService.calculDureeTsotra(precedent.getDate(), courant.getDate());
                Duration dureeTravaille = dureeService.calculDureeSarotra(precedent.getDate(), courant.getDate());

                courant.setDureeTotal(dureeService.calculerHeuresArrondies(dureeTotal));
                courant.setDureeTravaille(dureeService.calculerHeuresArrondies(dureeTravaille));
            }
            if (courant.getId() == cible.getId()) {
                objetMisAJour = courant;
            }
        }
        demandeStatutRepository.saveAll(listeComplete);

        return objetMisAJour;
    }

    public void deleteById(int id) {
        demandeStatutRepository.deleteById(id);
    }

    public List<DemandeStatut> getStatutDemandeActuel() {
        return demandeStatutRepository.getStatutActuelPourDemandes();
    }

    public List<DemandeStatut> getParDemande(int idDemande) {
        return demandeStatutRepository.findByDemandeId(idDemande);
    }

    public List<DemandeStatut> findByDemande(int idDemande) {
        return demandeStatutRepository.findByDemande(idDemande);
    }

    public List<DemandeStatut> findByStatut(int idStatut) {
        return demandeStatutRepository.findByStatut(idStatut);
    }

    public DemandeStatut saveDemandeStatut(DemandeStatut demandeStatut) {

        Demande demande = demandeRepository.findById(
                demandeStatut.getDemande().getId()).orElseThrow(() -> new RuntimeException("Demande non trouvée"));

        Statut statut = statutRepository.findById(
                demandeStatut.getStatut().getId()).orElseThrow(() -> new RuntimeException("Statut non trouvé"));

        List<DemandeStatut> historiques = demandeStatutRepository.findByDemande(demande.getId());

        DemandeStatut nouveau = new DemandeStatut();
        nouveau.setDemande(demande);
        nouveau.setStatut(statut);
        nouveau.setDate(demandeStatut.getDate());
        nouveau.setObservation(demandeStatut.getObservation());

        if (!historiques.isEmpty()) {

            DemandeStatut precedent = historiques.get(0);

            Duration dureeTotal = dureeService.calculDureeTsotra(precedent.getDate(), demandeStatut.getDate());
            nouveau.setDureeTotal(dureeService.calculerHeuresArrondies(dureeTotal));

            Duration dureeTravaille = dureeService.calculDureeSarotra(precedent.getDate(), demandeStatut.getDate());
            nouveau.setDureeTravaille(dureeService.calculerHeuresArrondies(dureeTravaille));

        } else {
            nouveau.setDureeTotal(0);
            nouveau.setDureeTravaille(0);
        }

        return demandeStatutRepository.save(nouveau);
    }

    public Level calculerLevel(DemandeStatut precedent, DemandeStatut courant) {

        if (precedent == null)
            return null;

        List<Indicateur> indicateurs = indicateurRepository.findByStatut1IdAndStatut2Id(
                precedent.getStatut().getId(),
                courant.getStatut().getId());

        return levelService.verifierNiveauAlerte(indicateurs, courant.getDureeTravaille());
    }



    public List<DemandeStatutDto> getAvecLevel(int idDemande) {

        List<DemandeStatut> liste = demandeStatutRepository.findByDemandeOrderByDateAsc(idDemande);

        List<DemandeStatutDto> result = new ArrayList<>();

        for (int i = 0; i < liste.size(); i++) {

            DemandeStatut courant = liste.get(i);

            DemandeStatutDto dto = new DemandeStatutDto();
            dto.setDemandeStatut(courant);

            if (i > 0) {
                DemandeStatut precedent = liste.get(i - 1);

                Level level = calculerLevel(precedent, courant);

                dto.setLevel(level != null ? level.getLevelNom() : null);
            }

            result.add(dto);
        }

        return result;
    }

    public List<DemandeStatutDto> getTousAvecLevel() {
        List<DemandeStatut> tous = demandeStatutRepository.findAll();
        List<DemandeStatutDto> result = new ArrayList<>();

        List<Integer> idsDemandes = new ArrayList<>();
        for (DemandeStatut ds : tous) {
            int idDemande = ds.getDemande().getId();
            if (!idsDemandes.contains(idDemande)) {
                idsDemandes.add(idDemande);
            }
        }

        for (int idDemande : idsDemandes) {
            List<DemandeStatutDto> dtos = getAvecLevel(idDemande);
            result.addAll(dtos);
        }

        return result;
    }
}
