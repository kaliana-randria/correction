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

import com.example.correction.entity.Operateur;
import com.example.correction.service.OperateurService;

@Controller
public class OperateurController {
    @Autowired
    private OperateurService operateurService;

    @GetMapping("/operateur/list")
    public ModelAndView listOperateurs() {
        ModelAndView mv = new ModelAndView("operateur/liste");
        List<Operateur> operateurs = operateurService.findAll();
        mv.addObject("listes", operateurs);
        return mv;
    }

    @GetMapping("/operateur/ajout-operateur")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("operateur/ajout-operateur");
        mv.addObject("operateur", new Operateur());

        return mv;
    }

    @PostMapping("/operateur/ajouter")
    public ModelAndView addOperateur(@ModelAttribute Operateur operateur,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            operateurService.save(operateur);

            redirectAttributes.addFlashAttribute("success", "Operateur ajouté avec succès !");

            mv.setViewName("redirect:/operateur/list");

        } catch (Exception e) {
            mv.setViewName("operateur/ajout-operateur");
            mv.addObject("operateur", operateur);
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/operateur/supprimer/{id}")
    public ModelAndView deleteOperateur(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/operateur/list");

        try {
            operateurService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Operateur supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/operateur/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Operateur operateur = operateurService.findById(id);

            if (operateur == null) {
                redirectAttributes.addFlashAttribute("error", "Operateur introuvable !");
                mv.setViewName("redirect:/operateur/list");
                return mv;
            }

            mv.setViewName("operateur/modif-operateur");
            mv.addObject("operateur", operateur);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/operateur/list");
        }

        return mv;
    }

    @PostMapping("/operateur/modifier")
    public ModelAndView updateOperateur(@ModelAttribute Operateur operateur,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            operateurService.save(operateur);
            redirectAttributes.addFlashAttribute("success", "Operateur modifiée avec succès !");
            mv.setViewName("redirect:/operateur/list");

        } catch (Exception e) {
            mv.setViewName("operateur/modif-operateur");
            mv.addObject("operateur", operateur);
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
}
