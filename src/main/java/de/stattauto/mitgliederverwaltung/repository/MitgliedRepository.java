package de.stattauto.mitgliederverwaltung.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.stattauto.mitgliederverwaltung.entity.Mitglied;

@Repository
public interface MitgliedRepository extends JpaRepository<Mitglied, Long>{
	Collection<Mitglied> findByKundennummer(long kundennummer);
	
	

	
	
}
