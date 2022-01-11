package dev.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
        Mission Mission = new Mission(libelle, taux);
        this.MissionRepository.save(Mission);
    }

    public List<Mission> listerMissions() {
        PageRequest pageRequest = PageRequest.of(1, 2, Sort.by("libelle"));
        return this.MissionRepository.findAll(pageRequest).toList();
    }

    public List<Mission> rechercherParVille(String ville) {
        return this.MissionRepository.listerParLibelle(ville);
    }

}
