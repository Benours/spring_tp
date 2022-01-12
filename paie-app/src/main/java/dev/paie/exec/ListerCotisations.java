package dev.paie.exec;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@Controller
@Profile("listerCotisation")
public class ListerCotisations implements CommandLineRunner {
	
	private CotisationRepository cotisationRepository;
	
	public ListerCotisations(CotisationRepository cotisationRepository) {
		this.cotisationRepository = cotisationRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------- Liste cotisation ---------");
		List<Cotisation> cotisations = cotisationRepository.findAll();
		cotisations.stream()
				   .map(Cotisation::getLibelle)
				   .forEach(System.out::println);
		System.out.println("--------- ---------------- ---------");
	}

}
