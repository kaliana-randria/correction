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

import com.example.correction.entity.Resolution;
import com.example.correction.service.ResolutionService;

@Controller
public class ResolutionController {
    @Autowired
    private ResolutionService resolutionService;

    @GetMapping("/resolution/list")
    public ModelAndView listResolutions() {
        ModelAndView mv = new ModelAndView("resolution/liste");
        List<Resolution> resolutions = resolutionService.findAll();
        mv.addObject("listes", resolutions);
        return mv;
    }

    @GetMapping("/resolution/ajout-resolution")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("resolution/ajout-resolution");
        mv.addObject("resolution", new Resolution());

        return mv;
    }

    @PostMapping("/resolution/ajouter")
    public ModelAndView addResolution(@ModelAttribute Resolution resolution,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            resolutionService.save(resolution);

            redirectAttributes.addFlashAttribute("success", "Resolution ajouté avec succès !");

            mv.setViewName("redirect:/resolution/list");

        } catch (Exception e) {
            mv.setViewName("resolution/ajout-resolution");
            mv.addObject("resolution", resolution);
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/resolution/supprimer/{id}")
    public ModelAndView deleteResolution(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/resolution/list");

        try {
            resolutionService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Resolution supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/resolution/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Resolution resolution = resolutionService.findById(id);

            if (resolution == null) {
                redirectAttributes.addFlashAttribute("error", "Resolution introuvable !");
                mv.setViewName("redirect:/resolution/list");
                return mv;
            }

            mv.setViewName("resolution/modif-resolution");
            mv.addObject("resolution", resolution);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/resolution/list");
        }

        return mv;
    }

    @PostMapping("/resolution/modifier")
    public ModelAndView updateResolution(@ModelAttribute Resolution resolution,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            resolutionService.save(resolution);
            redirectAttributes.addFlashAttribute("success", "Resolution modifiée avec succès !");
            mv.setViewName("redirect:/resolution/list");

        } catch (Exception e) {
            mv.setViewName("resolution/modif-resolution");
            mv.addObject("resolution", resolution);
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
}
