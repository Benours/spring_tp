package dev.paie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.RemunerationEmployeDTO;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.RemunerationService;

@RestController
@RequestMapping("CreateEmployee.html")
public class RemunerationController {

	private RemunerationService remunerationService;
	
	/**
	 * @param remunerationService
	 */
	public RemunerationController(RemunerationService remunerationService) {
		this.remunerationService = remunerationService;
	}

	@PostMapping
	public ResponseEntity<?> addRemuneration(RemunerationEmployeDTO remunerationEmployeDTO) {
		
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		
		// Check les données récupérer
		
		// Insérer les données pour ensuite les envoyées en base de données
		
		remunerationEmploye.setEntreprise(null);
		remunerationEmploye.setGrade(null);
		remunerationEmploye.setMatricule(null);
		remunerationEmploye.setProfilRemuneration(null);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.remunerationService.addRemuneration(remunerationEmploye));
	}
}
