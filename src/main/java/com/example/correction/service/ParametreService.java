package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Parametre;
import com.example.correction.repository.ParametreRepository;

@Service
public class ParametreService {
    @Autowired
    private ParametreRepository parametreRepository;

    @Autowired
    private ComparaisonService comparaisonService;

    public List<Parametre> findAll() {
        return parametreRepository.findAll();
    }

    public Parametre findById(int id) {
        return parametreRepository.findById(id).orElse(null);
    }

    public Parametre save(Parametre parametre) {
        return parametreRepository.save(parametre);
    }

    public void deleteById(int id) {
        parametreRepository.deleteById(id);
    }

    public List<Parametre> findByMatiereId(int matiereId) {
        return parametreRepository.findByMatiereId(matiereId);
    }

    public Parametre choisirParametre(double valiny, List<Parametre> parametres) {
        Parametre paramIzy = null;
        double diffIzy = 0;
        double diffActuel = 0;

        for (Parametre parametre : parametres) {
            if (comparaisonService.verifierCondition(valiny, parametre)) {
                if (paramIzy == null) {
                    paramIzy = parametre;
                } else {
                    diffActuel = Math.abs(valiny - parametre.getSeuil());
                    diffIzy = Math.abs(valiny - paramIzy.getSeuil());

                    if (diffActuel < diffIzy) {
                        paramIzy = parametre;
                    } else if (diffActuel == diffIzy) {
                        if (parametre.getSeuil() < paramIzy.getSeuil()) {
                            paramIzy = parametre;
                        }
                    }
                }
            }
        }

        return paramIzy;
    }
}
