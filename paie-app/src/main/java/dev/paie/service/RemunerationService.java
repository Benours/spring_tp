package dev.paie.service;

import org.springframework.stereotype.Service;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationRepository;

@Service
public class RemunerationService {
	
	private RemunerationRepository remunerationRepository;

	/**
	 * @param remunerationRepository
	 */
	public RemunerationService(RemunerationRepository remunerationRepository) {
		this.remunerationRepository = remunerationRepository;
	}

	public RemunerationEmploye addRemuneration(RemunerationEmploye remunerationEmploye) {
		// TODO Auto-generated method stub
		return remunerationRepository.save(remunerationEmploye);
	}
	
	

}
