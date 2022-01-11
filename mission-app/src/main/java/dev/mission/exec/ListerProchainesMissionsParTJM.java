package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.service.MissionServiceDataJpa;

@Controller
@Profile("listerTaux")
public class ListerProchainesMissionsParTJM implements CommandLineRunner{


	private MissionServiceDataJpa missionService;
	private float taux = 10f;

	public ListerProchainesMissionsParTJM(MissionServiceDataJpa missionService) {
		this.missionService = missionService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("----------");
		this.missionService.rechercherParTaux(LocalDate.now(), taux).forEach(m -> System.out.println(m.getLibelle()));
		System.out.println("----------");
	}

}
