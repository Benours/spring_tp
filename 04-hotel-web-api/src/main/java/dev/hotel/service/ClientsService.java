package dev.hotel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientsRepository;

@Service
public class ClientsService {

	private ClientsRepository clientsRepository;

	/**
	 * @param clientsRepository
	 */
	public ClientsService(ClientsRepository clientsRepository) {
		this.clientsRepository = clientsRepository;
	}
	
	@Transactional
    public Client insererClient(String nom, String prenoms) { // begin
        Client client = new Client(nom, prenoms);
        client.setNumero("C100" + (int) Math.floor(Math.random() * 99999));
        this.clientsRepository.save(client);
        return client;
    }
	
	public Client recupClient(String numero) {
		return this.clientsRepository.getClient(numero);
	}
	
	public List<Client> listerClient(int start, int size) {
		PageRequest pageRequest = PageRequest.of(start, size); 
		return this.clientsRepository.findAll(pageRequest).toList();
	}
}
