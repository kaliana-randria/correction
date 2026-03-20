package com.example.correction.controller.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.correction.entity.forage.Demande;
import com.example.correction.service.forage.DemandeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DemandeController {
    @Autowired
    private DemandeService demandeService;

    @GetMapping("/demande/list")
    public ModelAndView listDemandes() {
        ModelAndView mv = new ModelAndView("/forage/demande/liste");
        List<Demande> demandes = demandeService.findAll();
        mv.addObject("demandes", demandes);
        return mv;
    }
    
}
