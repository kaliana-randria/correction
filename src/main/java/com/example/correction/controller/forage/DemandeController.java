package com.example.correction.controller.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.correction.entity.forage.Client;
import com.example.correction.entity.forage.Demande;
import com.example.correction.service.forage.ClientService;
import com.example.correction.service.forage.DemandeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DemandeController {
    @Autowired
    private DemandeService demandeService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/demande/list")
    public ModelAndView listDemandes() {
        ModelAndView mv = new ModelAndView("/forage/demande/liste");
        List<Demande> demandes = demandeService.findAll();
        mv.addObject("listes", demandes);
        return mv;
    }

    @GetMapping("/demande/ajout-demande")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("forage/demande/ajout-demande");
        mv.addObject("demande", new Demande());

        List<Client> clients = clientService.findAll();

        mv.addObject("clients", clients);

        return mv;
    }

    @PostMapping("/demande/ajouter")
    public ModelAndView addDemande(@ModelAttribute Demande demande,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            demandeService.save(demande);

            redirectAttributes.addFlashAttribute("success", "Demande ajouté avec succès !");

            mv.setViewName("redirect:/demande/list");

        } catch (Exception e) {
            mv.setViewName("forage/demande/ajout-demande");
            mv.addObject("demande", demande);
            mv.addObject("clients", clientService.findAll());
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/demande/supprimer/{id}")
    public ModelAndView deleteDemande(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/demande/list");

        try {
            demandeService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Demande supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/demande/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Demande demande = demandeService.findById(id);

            if (demande == null) {
                redirectAttributes.addFlashAttribute("error", "Demande introuvable !");
                mv.setViewName("redirect:/demande/list");
                return mv;
            }

            mv.setViewName("forage/demande/modif-demande");
            mv.addObject("demande", demande);
            mv.addObject("clients", clientService.findAll());

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/demande/list");
        }

        return mv;
    }

    @PostMapping("/demande/modifier")
    public ModelAndView updateDemande(@ModelAttribute Demande demande,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            demandeService.save(demande);
            redirectAttributes.addFlashAttribute("success", "Demande modifiée avec succès !");
            mv.setViewName("redirect:/demande/list");

        } catch (Exception e) {
            mv.setViewName("forage/demande/modif-demande");
            mv.addObject("demande", demande);
            mv.addObject("clients", clientService.findAll());
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
    
}
