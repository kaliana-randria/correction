package com.example.correction.service.forage;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.Indicateur;
import com.example.correction.entity.forage.Level;

@Service
public class LevelService {
    public Level verifierNiveauAlerte(List<Indicateur> indicateurs, int dureeHeure) {

        for (Indicateur indic : indicateurs) {
            if (dureeHeure >= indic.getInterval1() && dureeHeure < indic.getInterval2()) {
                return indic.getLevel();
            }
        }

        return null;
    }

    
}
