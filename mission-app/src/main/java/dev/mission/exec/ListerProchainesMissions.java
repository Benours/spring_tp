package dev.mission.exec;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.service.MissionServiceDataJpa;

@Controller
@Profile("lister")
public class ListerProchainesMissions implements CommandLineRunner {


	private MissionServiceDataJpa missionService;
	private Date today = new Date(2022, 1, 11);

	public ListerProchainesMissions(MissionServiceDataJpa missionService) {
		this.missionService = missionService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("----------");
		this.missionService.rechercherParDate(today).forEach(m -> System.out.println(m.getLibelle()));
		System.out.println("----------");
	}

}
