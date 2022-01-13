package dev.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.hotel.entite.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {

	@Query("select c from Chambre c where c.code= :n")
	Chambre getChambre(@Param("n") String code);
}
