package com.example.correction.service.forage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.dto.DashboardDto;
import com.example.correction.dto.StatutStatDTO;
import com.example.correction.entity.forage.ChiffreAffaireTotal;
import com.example.correction.repository.forage.ClientRepository;
import com.example.correction.repository.forage.DevisRepository;
import com.example.correction.repository.forage.StatutRepository;
import com.example.correction.repository.forage.TypeDevisRepository;

@Service
public class DashboardService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TypeDevisRepository typeDevisRepository;

    @Autowired
    private StatutRepository statutRepository;

    @Autowired
    private ChiffreAffaireTotalService chiffreAffaireTotalService;

    @Autowired
    private DevisRepository devisRepository;

    public DashboardDto getDashboard() {

        DashboardDto dashboard = new DashboardDto();

        ChiffreAffaireTotal ca = chiffreAffaireTotalService.getChiffreFarany();
        int nbrClient = clientRepository.getNbrClient();
        // int nbrDevis = typeDevisRepository.getNbrDevis();
        int nbrDevisTotal = devisRepository.getNbrDevisTotal();

        // chiffreAffaireTotalService.montantGlobalDevis();
        dashboard.setChiffreAffaire(ca.getMontantDevisTotal());
        dashboard.setNbrClient(nbrClient);
        dashboard.setNbrDevis(nbrDevisTotal);

        List<StatutStatDTO> stats = statutRepository.getStatParStatut();

        dashboard.setStatuts(stats);

        return dashboard;
    }
}