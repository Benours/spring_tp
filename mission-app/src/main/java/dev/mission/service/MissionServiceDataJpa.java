package dev.mission.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;


@Service
public class MissionServiceDataJpa {

    private MissionRepository MissionRepository;

    public MissionServiceDataJpa(MissionRepository MissionRepository) {
        this.MissionRepository = MissionRepository;
    }

    public List<Mission> listerMissions() {
        return this.MissionRepository.findAll();
    }
    

    public List<Mission> rechercherParDate(LocalDate today) {
        return this.MissionRepository.listerParDate(today);
    }
    
    public List<Mission> rechercherParTaux(LocalDate today, BigDecimal taux) {
        return this.MissionRepository.listerParTaux(today, taux);
    }

}
