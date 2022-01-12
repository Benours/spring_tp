package dev.mission.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

	@Query("select m from Mission m where m.dateDebut > :d")
    List<Mission> listerParDate(@Param("d") LocalDate today);
	
	@Query("select m from Mission m where m.dateDebut > :d and m.tauxJournalier >= :t")
    List<Mission> listerParTaux(@Param("d") LocalDate today, @Param("t") BigDecimal taux);
}