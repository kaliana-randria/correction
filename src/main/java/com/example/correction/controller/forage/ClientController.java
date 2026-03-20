package com.example.correction.controller.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.correction.entity.forage.Client;
import com.example.correction.service.forage.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/client/list")
    public ModelAndView listClients() {
        ModelAndView mv = new ModelAndView("forage/client/liste");
        List<Client> clients = clientService.findAll();
        mv.addObject("clients", clients);
        return mv;
    }
    
}
