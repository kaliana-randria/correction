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
        
        Parametre parametreChoisi = parametreService.choisirParametre(valiny, parametres);

        if (parametreChoisi == null) {
            return null;
        }
        String resolution = parametreChoisi.getResolution().getNom();

        double noteFinal = comparaisonService.noteFinalAzo(resolution, notes, candidatId, matiereId);

        NoteFinal nf = new NoteFinal();
        nf.setCandidat(notes.get(0).getCandidat());
        nf.setMatiere(notes.get(0).getMatiere());
        nf.setValeur(noteFinal);

        return save(nf);
    }
}
