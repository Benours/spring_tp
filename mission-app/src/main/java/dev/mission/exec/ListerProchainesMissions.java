package dev.mission.exec;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.service.MissionServiceDataJpa;

@Controller
@Profile("lister")
public class ListerProchainesMissions implements CommandLineRunner {


	private MissionServiceDataJpa missionService;

	public ListerProchainesMissions(MissionServiceDataJpa missionService) {
		this.missionService = missionService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("----------");
		this.missionService.rechercherParDate(LocalDate.now()).forEach(m -> System.out.println(m.getLibelle()));
		System.out.println("----------");
	}

}
