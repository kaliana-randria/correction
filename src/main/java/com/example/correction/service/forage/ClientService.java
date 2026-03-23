package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Client;
import com.example.correction.repository.forage.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(int id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public void deleteById(int id){
        clientRepository.deleteById(id);
    }
}
