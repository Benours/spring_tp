package dev.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.hotel.entite.Chambre;
import dev.hotel.repository.ChambreRepository;

@Service
public class ChambreService {

	private ChambreRepository chambreRepository;


	/**
	 * @param chambreRepository
	 */
	public ChambreService(ChambreRepository chambreRepository) {
		this.chambreRepository = chambreRepository;
	}
	
	public List<Chambre> list() {
		return this.chambreRepository.findAll();
	}

	public Chambre recupChambre(String code) {
		return this.chambreRepository.getChambre(code);
	}

}
