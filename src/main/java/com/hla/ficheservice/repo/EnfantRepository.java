package com.hla.ficheservice.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hla.ficheservice.model.Enfant;

public interface EnfantRepository extends CrudRepository<Enfant, Long> {
	List<Enfant> findByPrenom(String prenom);
}
