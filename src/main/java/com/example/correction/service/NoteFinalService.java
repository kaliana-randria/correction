package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Note;
import com.example.correction.entity.NoteFinal;
import com.example.correction.entity.Parametre;
import com.example.correction.repository.NoteFinalRepository;

@Service
public class NoteFinalService {
    @Autowired
    private NoteFinalRepository noteFinalRepository;

    @Autowired
    private ComparaisonService comparaisonService;

    @Autowired
    private ParametreService parametreService;

    public NoteFinal save(NoteFinal noteFinal) {
        return noteFinalRepository.save(noteFinal);
    }

    public NoteFinal findByCandidatIdAndMatiereId(int candidatId, int matiereId) {
        return noteFinalRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);
    }

    public NoteFinal appliquerResolution(double valiny, List<Parametre> parametres, List<Note> notes, int candidatId,
            int matiereId) {

        // boolean condition = comparaisonService.verifierCondition(valiny, parametre);

        // if (condition) {

        //     String resolution = parametre.getResolution().getNom();

        //     double noteFinal = comparaisonService.noteFinalAzo(resolution, notes, candidatId, matiereId);

        //     NoteFinal nf = new NoteFinal();

        //     nf.setCandidat(notes.get(0).getCandidat());
        //     nf.setMatiere(notes.get(0).getMatiere());
        //     nf.setValeur(noteFinal);

        //     return save(nf);
        // }
        // return null;
        
        Parametre parametreChoisi = parametreService.choisirParametre(valiny, parametres);

        if (parametreChoisi == null) {
            return null;
        }

        // 3️⃣ récupérer la résolution (plus petit, plus grand, moyenne)
        String resolution = parametreChoisi.getResolution().getNom();

        // 4️⃣ calculer la note finale
        double noteFinal = comparaisonService.noteFinalAzo(resolution, notes, candidatId, matiereId);

        // 5️⃣ créer l'objet NoteFinal
        NoteFinal nf = new NoteFinal();
        nf.setCandidat(notes.get(0).getCandidat());  // notes.get(0) : on prend juste le candidat de la liste
        nf.setMatiere(notes.get(0).getMatiere());    // idem pour la matière
        nf.setValeur(noteFinal);

        // 6️⃣ sauvegarder et retourner
        return save(nf);
    }
}
