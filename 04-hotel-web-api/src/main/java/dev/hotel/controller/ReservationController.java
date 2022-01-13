package dev.hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
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
	public ReservationController(ReservationService reservationService, ClientsService clientsService) {
		this.reservationService = reservationService;
		this.clientsService = clientsService;
	}
	
	@PostMapping
	public ResponseEntity<?> doReservation(@RequestBody ReservationJson reservationJson) {
		System.out.println(" -------------------- ");
		System.out.println(reservationJson.toString());
		System.out.println(" -------------------- ");
				
		this.chambreService.list();
				
		System.out.println(" -------------------- ");
		System.out.println(reservationJson.getChambres().get(0));
		System.out.println(" -------------------- ");
		
		return ResponseEntity.ok().body("Hello");
	}

}
