package com.example.correction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.correction.dto.DifferenceNoteDto;
import com.example.correction.entity.Candidat;
import com.example.correction.entity.Matiere;
import com.example.correction.entity.Note;
import com.example.correction.entity.NoteFinal;
import com.example.correction.entity.Parametre;
import com.example.correction.repository.NoteRepository;
import com.example.correction.service.CandidatService;
import com.example.correction.service.MatiereService;
import com.example.correction.service.NoteFinalService;
import com.example.correction.service.NoteService;
import com.example.correction.service.ParametreService;

@Controller
public class NoteFinalController {
    @Autowired
    private CandidatService candidatService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @Autowired
    private ParametreService parametreService;

    @Autowired
    private NoteFinalService noteFinalService;

    @GetMapping("/note-final/calcul")
    public ModelAndView showFormCalcul() {
        ModelAndView mv = new ModelAndView("note-final/calcul-note-final");

        List<Candidat> candidats = candidatService.findAll();
        List<Matiere> matieres = matiereService.findAll();

        mv.addObject("candidats", candidats);
        mv.addObject("matieres", matieres);

        return mv;
    }

    @PostMapping("/note-final/calculer")
    public ModelAndView calculer(@RequestParam int candidatId, @RequestParam int matiereId) {
        ModelAndView mv = new ModelAndView("note-final/calcul");

        mv.addObject("candidats", candidatService.findAll());
        mv.addObject("matieres", matiereService.findAll());

        try {
            List<Note> notes = noteRepository.findByCandidatIdAndMatiereId(candidatId, matiereId);

            if (notes.isEmpty()) {
                mv.addObject("error", "Aucune note trouvée.");
                return mv;
            }

            List<DifferenceNoteDto> differences = noteService.calculerDifferences(candidatId, matiereId);
            double valiny = noteService.calculSommeDifferenceValiny(differences);

            List<Parametre> parametres = parametreService.findByMatiereId(matiereId);

            NoteFinal noteFinal = null;

            for (Parametre parametre : parametres) {
                noteFinal = noteFinalService.appliquerResolution(valiny, parametre, notes, candidatId, matiereId);

                if (noteFinal != null) {
                    break;
                }
            }

            if (noteFinal == null) {
                mv.addObject("error", "Note final null, pas de calcul.");
            } else {
                mv.addObject("noteFinal", noteFinal);
                mv.addObject("success", "Note finale calculée avec succès.");
            }

        } catch (Exception e) {
            mv.addObject("error", "Erreur : " + e.getMessage());
        }

        return mv;
    }
}
