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

import com.example.correction.entity.Matiere;
import com.example.correction.entity.Operateur;
import com.example.correction.entity.Parametre;
import com.example.correction.entity.Resolution;
import com.example.correction.service.MatiereService;
import com.example.correction.service.OperateurService;
import com.example.correction.service.ParametreService;
import com.example.correction.service.ResolutionService;

@Controller
public class ParametreController {
    @Autowired
    private ParametreService parametreService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private OperateurService operateurService;

    @Autowired
    private ResolutionService resolutionService;

    @GetMapping("/parametre/list")
    public ModelAndView listParametres() {
        ModelAndView mv = new ModelAndView("parametre/liste");
        List<Parametre> parametres = parametreService.findAll();
        mv.addObject("listes", parametres);
        return mv;
    }

    @GetMapping("/parametre/ajout-parametre")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("parametre/ajout-parametre");
        
        mv.addObject("parametre", new Parametre());
        
        List<Matiere> matieres = matiereService.findAll();
        List<Operateur> operateurs = operateurService.findAll();
        List<Resolution> resolutions = resolutionService.findAll();
        
        mv.addObject("matieres", matieres);
        mv.addObject("operateurs", operateurs);
        mv.addObject("resolutions", resolutions);
        
        return mv;
    }

    @PostMapping("/parametre/ajouter")
    public ModelAndView addParametre(@ModelAttribute Parametre parametre,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            parametreService.save(parametre);

            redirectAttributes.addFlashAttribute("success", "Parametre ajouté avec succès !");

            mv.setViewName("redirect:/parametre/list");

        } catch (Exception e) {
            mv.setViewName("parametre/ajout-parametre");
            mv.addObject("parametre", parametre);
            mv.addObject("matieres", matiereService.findAll());
            mv.addObject("operateurs", operateurService.findAll());
            mv.addObject("resolutions", resolutionService.findAll());
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/parametre/supprimer/{id}")
    public ModelAndView deleteParametre(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/parametre/list");

        try {
            parametreService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Parametre supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }


    @GetMapping("/parametre/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Parametre parametre = parametreService.findById(id);

            if (parametre == null) {
                redirectAttributes.addFlashAttribute("error", "Parametre introuvable !");
                mv.setViewName("redirect:/parametre/list");
                return mv;
            }

            mv.setViewName("parametre/modif-parametre");
            mv.addObject("parametre", parametre);
            mv.addObject("matieres", matiereService.findAll());
            mv.addObject("operateurs", operateurService.findAll());
            mv.addObject("resolutions", resolutionService.findAll());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/parametre/list");
        }

        return mv;
    }

    @PostMapping("/parametre/modifier")
    public ModelAndView updateParametre(@ModelAttribute Parametre parametre,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            parametreService.save(parametre);
            redirectAttributes.addFlashAttribute("success", "Parametre modifiée avec succès !");
            mv.setViewName("redirect:/parametre/list");

        } catch (Exception e) {
            mv.setViewName("parametre/modif-parametre");
            mv.addObject("parametre", parametre);
            mv.addObject("matieres", matiereService.findAll());
            mv.addObject("operateurs", operateurService.findAll());
            mv.addObject("resolutions", resolutionService.findAll());
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
}
