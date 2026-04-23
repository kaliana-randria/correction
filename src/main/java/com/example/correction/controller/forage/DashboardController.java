package com.example.correction.controller.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.correction.entity.forage.DemandeStatut;
import com.example.correction.service.forage.DashboardService;
import com.example.correction.service.forage.DemandeStatutService;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private DemandeStatutService demandeStatutService;

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {

        ModelAndView mv = new ModelAndView("forage/dashboard/dashboard");

        mv.addObject("data", dashboardService.getDashboard());

        return mv;
    }

    @GetMapping("/dashboard/statut/{id}")
    public ModelAndView detailStatut(@PathVariable int id) {

        ModelAndView mv = new ModelAndView("forage/dashboard/statut-detail");

        List<DemandeStatut> listes = demandeStatutService.findByStatut(id);

        String libelle = listes.isEmpty() ? "" : listes.get(0).getStatut().getLibelle();

        mv.addObject("listes", listes);
        mv.addObject("libelle", libelle);

        return mv;
    }
}
