package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.TypeDevis;
import com.example.correction.repository.forage.TypeDevisRepository;

@Service
public class TypeDevisService {
    @Autowired
    private TypeDevisRepository typeDevisRepository;

    public List<TypeDevis> findAll(){
        return typeDevisRepository.findAll();
    }

    public TypeDevis findById(int id){
        return typeDevisRepository.findById(id).orElse(null);
    }

    public TypeDevis save(TypeDevis typeDevis){
        return typeDevisRepository.save(typeDevis);
    }

    public void deleteById(int id){
        typeDevisRepository.deleteById(id);
    }
}
