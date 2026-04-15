package com.example.correction.service.forage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Reduction;
import com.example.correction.repository.forage.ReductionRepository;

@Service
public class ReductionService {
    @Autowired
    private ReductionRepository reductionRepository;

    public Reduction avoirValeur(){
        return reductionRepository.findTopByOrderByIdDesc();
    }
}
