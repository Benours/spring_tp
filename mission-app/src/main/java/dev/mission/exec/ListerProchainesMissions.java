package dev.mission.exec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.service.MissionServiceDataJpa;

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
		this.missionService.listerMissions().forEach(m -> System.out.println(m.getLibelle()));
		System.out.println("----------");
	}

}
