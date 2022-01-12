package dev.paie.exec;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationRepository;

@Controller
@Profile("insererRemuneration")
public class InsererRemuneration implements CommandLineRunner {
	
	private RemunerationRepository remunerationRepository;
	private EntrepriseRepository entrepriseRepository;
	private ProfilRepository profilRepository;
	private GradeRepository gradeRepository;
	
	public InsererRemuneration(RemunerationRepository remunerationRepository, EntrepriseRepository entrepriseRepository, ProfilRepository profilRepository, GradeRepository gradeRepository) {
		super();
		this.remunerationRepository = remunerationRepository;
		this.entrepriseRepository = entrepriseRepository;
		this.profilRepository = profilRepository;
		this.gradeRepository = gradeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Entreprise entreprise = new Entreprise();
		
		entreprise.setDenomination("Sonup");
		entreprise.setCodeNaf("6202A");
		entreprise.setSiret("1234565000022");
		
		this.entrepriseRepository.save(entreprise);

		Grade grade = new Grade();
		
		grade.setCode("GRADE_E");
		grade.setNbHeuresBase(new BigDecimal(152));
		grade.setTauxBase(new BigDecimal(51));
		
		this.gradeRepository.save(grade);
		
		ProfilRemuneration profilRemuneration = new ProfilRemuneration();
		
		profilRemuneration.setCode("Développeur");
		
		this.profilRepository.save(profilRemuneration);
		
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		
		remunerationEmploye.setMatricule("FRXXXXXX");
		remunerationEmploye.setEntreprise(entreprise);
		remunerationEmploye.setProfilRemuneration(profilRemuneration);
		remunerationEmploye.setGrade(grade);
		
		this.remunerationRepository.save(remunerationEmploye);
		
		
	}

}
