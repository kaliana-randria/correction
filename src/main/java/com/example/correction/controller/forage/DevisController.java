package com.example.correction.controller.forage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.correction.dto.DevisFormDto;
import com.example.correction.entity.Note;
import com.example.correction.entity.forage.Demande;
import com.example.correction.entity.forage.Devis;
import com.example.correction.entity.forage.DevisDetails;
import com.example.correction.repository.forage.DemandeRepository;
import com.example.correction.service.forage.DevisDetailsService;
import com.example.correction.service.forage.DevisService;
import com.example.correction.service.forage.TypeDevisService;

@Controller
public class DevisController {

    @Autowired
    private TypeDevisService typeDevisService;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private DevisService devisService;

    @Autowired
    private DevisDetailsService devisDetailsService;

    @GetMapping("/devis/list")
    public ModelAndView listClients() {
        ModelAndView mv = new ModelAndView("forage/devis/liste");
        List<Devis> devis = devisService.findAll();
        mv.addObject("listes", devis);
        return mv;
    }

    @GetMapping("/devis/ajout-devis")
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView("forage/devis/ajout-devis");

        mv.addObject("type_devis", typeDevisService.findAll());
        mv.addObject("devisForm", new DevisFormDto());

        return mv;
    }

    @GetMapping("/devis/demande/{id}")
    @ResponseBody
    public ResponseEntity<?> getDemande(@PathVariable int id) {

        Optional<Demande> demande = demandeRepository.findById(id);

        if (demande.isPresent()) {
            return ResponseEntity.ok(demande.get());
        } else {
            return ResponseEntity.badRequest().body("Demande introuvable");
        }
    }

    @PostMapping("/devis/ajout-devis")
    public String create(@ModelAttribute DevisFormDto form) {

        devisService.creationDevis(form);

        return "redirect:/devis/list";
    }

    @GetMapping("/devis/devis-details/{id}")
    public ModelAndView voirDetails(@PathVariable int id, RedirectAttributes redirectAttributes) {

        ModelAndView mv = new ModelAndView();

        try {
            Devis devis = devisService.findById(id);

            List<DevisDetails> details = devisDetailsService.findByDevis(devis);

            if (devis == null) {
                redirectAttributes.addFlashAttribute("error", "Devis introuvable !");
                mv.setViewName("redirect:/devis/list");
                return mv;
            }

            mv.setViewName("forage/devis/devis-details");
            mv.addObject("devis", devis);
            mv.addObject("details", details);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/devis/list");
        }

        return mv;
    }
}