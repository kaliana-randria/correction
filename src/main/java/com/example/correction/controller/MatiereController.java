package com.example.correction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.correction.entity.Matiere;
import com.example.correction.service.MatiereService;

@Controller
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    @GetMapping("/matiere/list")
    public ModelAndView listMatieres() {
        ModelAndView mv = new ModelAndView("matiere/liste");
        List<Matiere> matieres = matiereService.findAll();
        mv.addObject("listes", matieres);
        return mv;
    }

    @GetMapping("/matiere/ajout-matiere")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("matiere/ajout-matiere");
        mv.addObject("matiere", new Matiere());
        
        return mv;
    }

    @PostMapping("/matiere/ajouter")
    public ModelAndView addMatiere(@ModelAttribute Matiere matiere, 
                                    RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        
        try {
            matiereService.save(matiere);
            
            redirectAttributes.addFlashAttribute("success", "Matiere ajouté avec succès !");
            
            mv.setViewName("redirect:/matiere/list");
            
        } catch (Exception e) {
            mv.setViewName("matiere/ajout-matiere");
            mv.addObject("matiere", matiere);
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }
        
        return mv;
    }
}
