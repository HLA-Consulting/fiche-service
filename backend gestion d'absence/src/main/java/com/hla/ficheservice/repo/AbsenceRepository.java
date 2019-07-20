package com.hla.ficheservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.hla.ficheservice.model.Absence;



public interface AbsenceRepository extends CrudRepository<Absence, Long> {
	
	Optional<Absence> findById(long id);
	@SuppressWarnings("unchecked")
	Absence save(Absence absence);
	List<Absence> findByEnfantId_enfant(long id);
}
