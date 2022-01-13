package dev.hotel.service;

import org.springframework.stereotype.Service;

import dev.hotel.entite.Reservation;
import dev.hotel.repository.ReservationRepository;

@Service
public class ReservationService {

	private ReservationRepository reservationRepository;

	/**
	 * @param reservationRepository
	 */
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public Reservation insererReservation(Reservation reservation) {
		
		this.reservationRepository.save(reservation);
		return reservation;
	}
}
