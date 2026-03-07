package com.example.correction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.correction.entity.Candidat;
import com.example.correction.entity.Correcteur;
import com.example.correction.entity.Matiere;
import com.example.correction.entity.Note;
import com.example.correction.service.CandidatService;
import com.example.correction.service.CorrecteurService;
import com.example.correction.service.MatiereService;
import com.example.correction.service.NoteService;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;
    
    @Autowired
    private CandidatService candidatService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private CorrecteurService correcteurService;

    @GetMapping("/note/list")
    public ModelAndView listNotes() {
        ModelAndView mv = new ModelAndView("note/liste");
        List<Note> notes = noteService.findAll();
        mv.addObject("listes", notes);
        return mv;
    }

    @GetMapping("/note/ajout-note")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("note/ajout-note");

        mv.addObject("note", new Note());

        List<Candidat> candidats = candidatService.findAll();
        List<Matiere> matieres = matiereService.findAll();
        List<Correcteur> correcteurs = correcteurService.findAll();

        mv.addObject("candidats", candidats);
        mv.addObject("matieres", matieres);
        mv.addObject("correcteurs", correcteurs);

        return mv;
    }

    @PostMapping("/note/ajouter")
    public ModelAndView addNote(@ModelAttribute Note note,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            noteService.save(note);

            redirectAttributes.addFlashAttribute("success", "Note ajouté avec succès !");

            mv.setViewName("redirect:/note/list");

        } catch (Exception e) {
            mv.setViewName("note/ajout-note");
            mv.addObject("note", note);
            mv.addObject("candidats", candidatService.findAll());
            mv.addObject("matieres", matiereService.findAll());
            mv.addObject("correcteurs", correcteurService.findAll());
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/note/supprimer/{id}")
    public ModelAndView deletenNote(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/note/list");

        try {
            noteService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Note supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/note/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Note note = noteService.findById(id);

            if (note == null) {
                redirectAttributes.addFlashAttribute("error", "Note introuvable !");
                mv.setViewName("redirect:/note/list");
                return mv;
            }

            mv.setViewName("note/modif-note");
            mv.addObject("note", note);
            mv.addObject("candidats", candidatService.findAll());
            mv.addObject("matieres", matiereService.findAll());
            mv.addObject("correteurs", correcteurService.findAll());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/note/list");
        }

        return mv;
    }

    @PostMapping("/note/modifier")
    public ModelAndView updatenote(@ModelAttribute Note note,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            noteService.save(note);
            redirectAttributes.addFlashAttribute("success", "Note modifiée avec succès !");
            mv.setViewName("redirect:/note/list");

        } catch (Exception e) {
            mv.setViewName("note/modif-note");
            mv.addObject("note", note);
            mv.addObject("candidats", candidatService.findAll());
            mv.addObject("matieres", matiereService.findAll());
            mv.addObject("correteurs", correcteurService.findAll());
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }

}
