package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.ChiffreAffaireTotal;
import com.example.correction.repository.forage.ChiffreAffaireTotalRepository;
import com.example.correction.repository.forage.DevisDetailsRepository;

@Service
public class ChiffreAffaireTotalService {
    @Autowired
    private ChiffreAffaireTotalRepository chiffreAffaireTotalRepository;

    @Autowired
    private DevisDetailsRepository devisDetailsRepository;

    public List<ChiffreAffaireTotal> findAll() {
        return chiffreAffaireTotalRepository.findAll();
    }

    public ChiffreAffaireTotal save(ChiffreAffaireTotal chiffreAffaireTotal){
        return chiffreAffaireTotalRepository.save(chiffreAffaireTotal);
    }

    public double montantGlobalDevis(){
        double montant = devisDetailsRepository.getMontantDevisTotal();

        ChiffreAffaireTotal chiffreAffaireTotal = new ChiffreAffaireTotal();
        chiffreAffaireTotal.setMontantDevisTotal(montant);

        save(chiffreAffaireTotal);

        return montant;
    }

    public ChiffreAffaireTotal getChiffreFarany() {
        return chiffreAffaireTotalRepository.findTopByOrderByIdDesc();
    }
}
