package dev.mission.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;


@Service
public class MissionServiceDataJpa {

    private MissionRepository MissionRepository;

    public MissionServiceDataJpa(MissionRepository MissionRepository) {
        this.MissionRepository = MissionRepository;
    }

    @Transactional
    public void insererMission(String libelle, BigDecimal taux) { // begin
        Mission mission = new Mission(libelle, taux);
        this.MissionRepository.save(mission);
    }

    public List<Mission> listerMissions() {
        return this.MissionRepository.findAll();
    }
    

    public List<Mission> rechercherParDate(Date today) {
        return this.MissionRepository.listerParDate(today);
    }

}
