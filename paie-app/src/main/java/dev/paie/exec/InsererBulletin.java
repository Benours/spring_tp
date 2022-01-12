package dev.paie.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationRepository;

@Controller
@Profile("insererBulletin")
public class InsererBulletin implements CommandLineRunner {

	private RemunerationRepository remunerationRepository;
	private EntrepriseRepository entrepriseRepository;
	private ProfilRepository profilRepository;
	private GradeRepository gradeRepository;
	private BulletinRepository bulletinRepository;
	private PeriodeRepository periodeRepository;

	public InsererBulletin(RemunerationRepository remunerationRepository, EntrepriseRepository entrepriseRepository, ProfilRepository profilRepository, GradeRepository gradeRepository, BulletinRepository bulletinRepository, PeriodeRepository periodeRepository) {
		super();
		this.remunerationRepository = remunerationRepository;
		this.entrepriseRepository = entrepriseRepository;
		this.profilRepository = profilRepository;
		this.gradeRepository = gradeRepository;
		this.bulletinRepository = bulletinRepository;
		this.periodeRepository = periodeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
Entreprise entreprise = new Entreprise();
		
		entreprise.setDenomination("Ubisoft");
		entreprise.setCodeNaf("6202A");
		entreprise.setSiret("9876543000022");
		
		this.entrepriseRepository.save(entreprise);

		Grade grade = new Grade();
		
		grade.setCode("GRADE_F");
		grade.setNbHeuresBase(new BigDecimal(152));
		grade.setTauxBase(new BigDecimal(61));
		
		this.gradeRepository.save(grade);
		
		ProfilRemuneration profilRemuneration = new ProfilRemuneration();
		
		profilRemuneration.setCode("Commercial");
		
		this.profilRepository.save(profilRemuneration);
		
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		
		remunerationEmploye.setMatricule("DEXXXXXX");
		remunerationEmploye.setEntreprise(entreprise);
		remunerationEmploye.setProfilRemuneration(profilRemuneration);
		remunerationEmploye.setGrade(grade);
		
		this.remunerationRepository.save(remunerationEmploye);
		
		Periode periode = new Periode();
		
		periode.setDateDebut(LocalDate.now());
		periode.setDateFin(LocalDate.of(2022, 12, 31));
		
		this.periodeRepository.save(periode);
		
		BulletinSalaire bulletinSalaire = new BulletinSalaire();
		
		bulletinSalaire.setRemunerationEmploye(remunerationEmploye);
		bulletinSalaire.setPeriode(periode);

		this.bulletinRepository.save(bulletinSalaire);
	}

}
