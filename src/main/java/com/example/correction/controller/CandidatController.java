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
import com.example.correction.service.CandidatService;

@Controller
public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @GetMapping("/candidat/list")
    public ModelAndView listCandidats() {
        ModelAndView mv = new ModelAndView("candidat/liste");
        List<Candidat> candidats = candidatService.findAll();
        mv.addObject("listes", candidats);
        return mv;
    }

    @GetMapping("/candidat/ajout-candidat")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("candidat/ajout-candidat");
        mv.addObject("candidat", new Candidat());

        return mv;
    }

    @PostMapping("/candidat/ajouter")
    public ModelAndView addCandidat(@ModelAttribute Candidat candidat,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            candidatService.save(candidat);

            redirectAttributes.addFlashAttribute("success", "Candidat ajouté avec succès !");

            mv.setViewName("redirect:/candidat/list");

        } catch (Exception e) {
            mv.setViewName("candidat/ajout-candidat");
            mv.addObject("candidat", candidat);
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/candidat/supprimer/{id}")
    public ModelAndView deleteCandidat(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/candidat/list");

        try {
            candidatService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Candidat supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/candidat/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Candidat candidat = candidatService.findById(id);

            if (candidat == null) {
                redirectAttributes.addFlashAttribute("error", "Candidat introuvable !");
                mv.setViewName("redirect:/candidat/list");
                return mv;
            }

            mv.setViewName("candidat/modif-candidat");
            mv.addObject("candidat", candidat);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/candidat/list");
        }

        return mv;
    }

    @PostMapping("/candidat/modifier")
    public ModelAndView updateCandidat(@ModelAttribute Candidat candidat,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            candidatService.save(candidat);
            redirectAttributes.addFlashAttribute("success", "Candidat modifiée avec succès !");
            mv.setViewName("redirect:/candidat/list");

        } catch (Exception e) {
            mv.setViewName("candidat/modif-candidat");
            mv.addObject("candidat", candidat);
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
}
