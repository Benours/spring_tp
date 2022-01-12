package dev.paie.exec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

@Controller
@Profile("insererProfil")
public class InsererProfil implements CommandLineRunner {
	
	private ProfilRepository profilRepository;
	
	public InsererProfil(ProfilRepository profilRepository) {
		super();
		this.profilRepository = profilRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ProfilRemuneration profilRemuneration = new ProfilRemuneration();
		
		profilRemuneration.setCode("Ingénieur");
		
		this.profilRepository.save(profilRemuneration);
	}

}
