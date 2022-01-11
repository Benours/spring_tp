package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

@Controller
@Profile("insert")
public class InsererMission implements CommandLineRunner {

	private MissionRepository missionRepository;

	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean add = true;

		while (add) {
			Mission mission = new Mission();

			System.out.println("Libelle:");
			String libelle = sc.next();
			System.out.println("Taux journalier:");
			String taux = sc.next();
			
			mission.setLibelle(libelle);
			mission.setTauxJournalier(new BigDecimal(taux));
			mission.setDateDebut(LocalDate.of(2022, 1, 30));
			mission.setDateFin(LocalDate.of(2022, 3, 4));

			this.missionRepository.save(mission);
			System.out.println("Ajouter mission ?(y/n)");
			String reponse = sc.next();
			if (reponse.contains("n"))
				add = false;
		}
		sc.close();
	}
}
