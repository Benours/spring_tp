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

		List<Chambre> listChambre = new ArrayList<Chambre>();
		
		reservationJson.getChambres().forEach(c -> listChambre.add(this.chambreService.recupChambre(c)));
		
		reservation.setChambres(listChambre);
		
		reservation.setDateDebut(reservationJson.getDateDebut());
		
		reservation.setDateFin(reservationJson.getDateFin());
		
		reservation.setClient(this.clientsService.recupClient(reservationJson.getNumeroClient()));
		
		return ResponseEntity.ok()
				.body(this.reservationService.insererReservation(reservation));
	}

}
