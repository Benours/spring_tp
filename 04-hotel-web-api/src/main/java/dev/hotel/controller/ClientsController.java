package dev.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.service.ClientsService;

@RestController
@RequestMapping("clients")
public class ClientsController {

	private ClientsService clientsService;

	/**
	 * @param clientsService
	 */
	public ClientsController(ClientsService clientsService) {
		this.clientsService = clientsService;
	}

	@GetMapping
	public List<Client> listBack(@RequestParam String start, @RequestParam String size) {
		return this.clientsService.listerClient(Integer.parseInt(start), Integer.parseInt(size));
	}

	@GetMapping("/{numero}")
	public  ResponseEntity<?> getClient(@PathVariable String numero) {
		if (this.clientsService.recupClient(numero) == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Le client " + numero + " n'existe pas");

		return ResponseEntity.ok()
				.body(this.clientsService.recupClient(numero));
	}
	
	@PostMapping
	public Client doClient(@RequestBody @Valid Client client) {
		return this.clientsService.insererClient(client.getNom(), client.getPrenoms());
	}

}
