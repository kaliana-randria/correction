package com.example.correction.controller.forage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.correction.entity.forage.ChiffreAffaireTotal;
import com.example.correction.service.forage.ChiffreAffaireTotalService;

@Controller
public class ChiffreAffaireTotalController {
    @Autowired
    private ChiffreAffaireTotalService chiffreAffaireTotalService;

    @GetMapping("/chiffre-affaire/list")
    public ModelAndView chiffreAffaire() {
        ModelAndView mv = new ModelAndView("forage/chiffre-affaire/affiche-chiffre");
        ChiffreAffaireTotal chiffre = chiffreAffaireTotalService.getChiffreFarany();
        mv.addObject("chiffre", chiffre);
        return mv;
    }

    @GetMapping("/chiffre-affaire/calcul")
    public String calculerChiffreAffaire() {

        chiffreAffaireTotalService.montantGlobalDevis();

        return "redirect:/chiffre-affaire/list";
    }
}
