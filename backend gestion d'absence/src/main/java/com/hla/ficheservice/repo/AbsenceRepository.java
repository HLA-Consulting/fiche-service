package com.hla.ficheservice.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.hla.ficheservice.model.Absence;



public interface AbsenceRepository extends CrudRepository<Absence, Long> {
	
	List<Absence> findById(long id);
	List<Absence> findByEnfantPrenomAndEnfantNom(String prenom, String nom);
	@SuppressWarnings("unchecked")
	Absence save(Absence absence);
}
