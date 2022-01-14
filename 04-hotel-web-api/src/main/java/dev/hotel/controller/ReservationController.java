package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Reservation;
import dev.hotel.exception.ChambreException;
import dev.hotel.json.ReservationJson;
import dev.hotel.service.ChambreService;
import dev.hotel.service.ClientsService;
import dev.hotel.service.ReservationService;

@RestController
@RequestMapping("reservations")
public class ReservationController {

	private ReservationService reservationService;
	private ClientsService clientsService;
	private ChambreService chambreService;

	/**
	 * @param reservationService
	 */
	public ReservationController(ReservationService reservationService, ClientsService clientsService, ChambreService chambreService) {
		this.reservationService = reservationService;
		this.clientsService = clientsService;
		this.chambreService = chambreService;
	}

	@PostMapping
	public ResponseEntity<?> doReservation(@RequestBody ReservationJson reservationJson) {
		Reservation reservation = new Reservation();

		if (this.clientsService.recupClient(reservationJson.getNumeroClient()) == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("numéro client " + reservationJson.getNumeroClient() + " non trouvé");
		else {
			reservation.setClient(this.clientsService.recupClient(reservationJson.getNumeroClient()));
		}
		
		List<Chambre> listChambre = new ArrayList<Chambre>();
		List<String> listErreur = new ArrayList<String>();
		boolean check = false;
		
//		reservationJson.getChambres().forEach(c -> listChambre.add(this.chambreService.recupChambre(c)));
		
		for (String string : reservationJson.getChambres()) {
			if (this.chambreService.recupChambre(string) == null) {
				listErreur.add("la chambre " + string + " n'existe pas");
				check = true;
			}
			else {
				listChambre.add(this.chambreService.recupChambre(string));
			}
		}
		if (check)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listErreur);
		
		reservation.setChambres(listChambre);
		
		reservation.setDateDebut(reservationJson.getDateDebut());
		
		reservation.setDateFin(reservationJson.getDateFin());
		
				
		return ResponseEntity.ok()
				.body(this.reservationService.insererReservation(reservation));
	}

}
