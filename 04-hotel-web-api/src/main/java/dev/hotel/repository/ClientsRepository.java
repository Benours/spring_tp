package dev.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.hotel.entite.Client;

public interface ClientsRepository extends JpaRepository<Client, Integer> {

	@Query("select c from Client c where c.numero= :n")
	Client getClient(@Param("n") String numero);

}
