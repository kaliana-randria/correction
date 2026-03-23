package com.example.correction.controller.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.correction.entity.forage.Client;
import com.example.correction.service.forage.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/client/list")
    public ModelAndView listClients() {
        ModelAndView mv = new ModelAndView("forage/client/liste");
        List<Client> clients = clientService.findAll();
        mv.addObject("listes", clients);
        return mv;
    }

    @GetMapping("/client/ajout-client")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("forage/client/ajout-client");
        mv.addObject("client", new Client());

        return mv;
    }

    @PostMapping("/client/ajouter")
    public ModelAndView addClient(@ModelAttribute Client client,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            clientService.save(client);

            redirectAttributes.addFlashAttribute("success", "Client ajouté avec succès !");

            mv.setViewName("redirect:/client/list");

        } catch (Exception e) {
            mv.setViewName("forage/client/ajout-client");
            mv.addObject("client", client);
            mv.addObject("error", "Erreur lors de l'ajout : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/client/supprimer/{id}")
    public ModelAndView deleteClient(@PathVariable int id,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/client/list");

        try {
            clientService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Client supprimé avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression : " + e.getMessage());
        }

        return mv;
    }

    @GetMapping("/client/modifier/{id}")
    public ModelAndView showEditForm(@PathVariable int id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            Client client = clientService.findById(id);

            if (client == null) {
                redirectAttributes.addFlashAttribute("error", "Client introuvable !");
                mv.setViewName("redirect:/client/list");
                return mv;
            }

            mv.setViewName("forage/client/modif-client");
            mv.addObject("client", client);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur : " + e.getMessage());
            mv.setViewName("redirect:/client/list");
        }

        return mv;
    }

    @PostMapping("/client/modifier")
    public ModelAndView updateClient(@ModelAttribute Client client,
            RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();

        try {
            clientService.save(client);
            redirectAttributes.addFlashAttribute("success", "Client modifiée avec succès !");
            mv.setViewName("redirect:/client/list");

        } catch (Exception e) {
            mv.setViewName("forage/client/modif-client");
            mv.addObject("client", client);
            mv.addObject("error", "Erreur lors de la modification : " + e.getMessage());
        }

        return mv;
    }
    
}
