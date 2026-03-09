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

import com.example.correction.entity.Correcteur;
import com.example.correction.service.CorrecteurService;

@Controller
public class CorrecteurController {
    @Autowired
    private CorrecteurService correcteurService;

    @GetMapping("/correcteur/list")
    public ModelAndView listCorrecteurs() {
        ModelAndView mv = new ModelAndView("correcteur/liste");
        List<Correcteur> correcteurs = correcteurService.findAll();
        mv.addObject("listes", correcteurs);
        return mv;
    }

    @GetMapping("/correcteur/ajout-correcteur")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("correcteur/ajout-correcteur");
        mv.addObject("correcteur", new Correcteur());

        return mv;
    }

    @PostMapping("/correcteur/ajouter")
    public ModelAndView addCorrecteur(@ModelAttribute Correcteur correcteur,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            correcteurService.save(correcteur);

            redirectAttributes.addFlashAttribute("success", "Correcteur ajouté avec succès !");

            mv.setViewName("redirect:/correcteur/list");

        } catch (Exception e) {
            mv.setViewName("correcteur/ajout-correcteur");
            mv.addObject("correcteur", correcteur);
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/correcteur/supprimer/{id}")
    public ModelAndView deleteCorrecteur(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/correcteur/list");

        try {
            correcteurService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Correcteur supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/correcteur/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Correcteur correcteur = correcteurService.findById(id);

            if (correcteur == null) {
                redirectAttributes.addFlashAttribute("error", "Correcteur introuvable !");
                mv.setViewName("redirect:/correcteur/list");
                return mv;
            }

            mv.setViewName("correcteur/modif-correcteur");
            mv.addObject("correcteur", correcteur);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/correcteur/list");
        }

        return mv;
    }

    @PostMapping("/correcteur/modifier")
    public ModelAndView updateCorrecteur(@ModelAttribute Correcteur correcteur,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            correcteurService.save(correcteur);
            redirectAttributes.addFlashAttribute("success", "Correcteur modifiée avec succès !");
            mv.setViewName("redirect:/correcteur/list");

        } catch (Exception e) {
            mv.setViewName("correcteur/modif-correcteur");
            mv.addObject("correcteur", correcteur);
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
}
