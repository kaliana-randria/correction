package com.example.correction.controller.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.correction.dto.DemandeStatutDto;
import com.example.correction.entity.forage.DemandeStatut;
import com.example.correction.service.forage.DemandeStatutService;
import com.example.correction.service.forage.StatutService;

@Controller
public class DemandeStatutController {
    @Autowired
    private DemandeStatutService demandeStatutService;

    @Autowired
    private StatutService statutService;

    @GetMapping("/demande-statut/statutActuel")
    public ModelAndView listStatutDemandeActuel() {
        ModelAndView mv = new ModelAndView("forage/demande-statut/liste-demande-statut-actuel");
        List<DemandeStatut> demandeStatuts = demandeStatutService.getStatutDemandeActuel();
        mv.addObject("listes", demandeStatuts);
        return mv;
    }


    @GetMapping("/demande-statut/historique")
    public ModelAndView listDemandeStatut() {
        ModelAndView mv = new ModelAndView("forage/demande-statut/historique");
        // List<DemandeStatut> demandeStatuts = demandeStatutService.findAll();
        List<DemandeStatutDto> demandeStatuts = demandeStatutService.getTousAvecLevel();
        mv.addObject("listes", demandeStatuts);
        return mv;
    }

    @GetMapping("/demande-statut/details-historique/{id}")
    public ModelAndView listDemandeStatutDetails(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("forage/demande-statut/details-historique");
        List<DemandeStatutDto> demandeStatuts = demandeStatutService.getAvecLevel(id);
        // List<DemandeStatut> demandeStatuts = demandeStatutService.getParDemande(id);
        mv.addObject("listes", demandeStatuts);
        return mv;
    }

    @GetMapping("/demande-statut/form-demande-statut/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            DemandeStatut demandeStatut = demandeStatutService.findById(id);

            if (demandeStatut == null) {
                redirectAttributes.addFlashAttribute("error", "demande statut introuvable !");
                mv.setViewName("redirect:/demande-statut/statutActuel");
                return mv;
            }

            mv.setViewName("forage/demande-statut/form-demande-statut");
            mv.addObject("demandeStatut", demandeStatut);
            mv.addObject("statuts", statutService.findAll());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/demande-statut/statutActuel");
        }

        return mv;
    }

    @PostMapping("/demande-statut/save")
    public ModelAndView manampyStatutDemande(@ModelAttribute DemandeStatut demandeStatut,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            demandeStatutService.saveDemandeStatut(demandeStatut);
            redirectAttributes.addFlashAttribute("success", "Demande statut niampy !");
            mv.setViewName("redirect:/demande-statut/statutActuel");

        } catch (Exception e) {
            mv.setViewName("forage/demande-statut/form-demande-statut");
            mv.addObject("demandeStatut", demandeStatut);
            mv.addObject("error", "Erreur nanampy statut demande : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/demande-statut/modifier-obsrvation-date/{id}")
    public ModelAndView formModifObservationDate(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            DemandeStatut demandeStatut = demandeStatutService.findById(id);

            if (demandeStatut == null) {
                redirectAttributes.addFlashAttribute("error", "Demande Statut introuvable !");
                mv.setViewName("redirect:/demande-statut/statutActuel");
                return mv;
            }

            mv.setViewName("forage/demande-statut/modifier-obsrvation-date");
            mv.addObject("demandeStatut", demandeStatut);
            mv.addObject("statuts", statutService.findAll());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/demande-statut/statutActuel");
        }

        return mv;
    }

    @PostMapping("/demande-statut/modifier-obsrvation-date")
    public ModelAndView updateClient(@ModelAttribute DemandeStatut demandeStatut,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            demandeStatutService.updateObservationDate(demandeStatut);
            redirectAttributes.addFlashAttribute("success", "Demande Statut (Observation / date) modifiée avec succès !");
            mv.setViewName("redirect:/demande-statut/statutActuel");

        } catch (Exception e) {
            mv.setViewName("forage/demande-statut/modifier-obsrvation-date");
            mv.addObject("demandeStatut", demandeStatut);
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
}
