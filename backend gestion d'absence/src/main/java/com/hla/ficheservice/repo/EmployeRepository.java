package com.hla.ficheservice.repo;

import org.springframework.data.repository.CrudRepository;


import com.hla.ficheservice.model.Employe;



public interface EmployeRepository extends CrudRepository<Employe, Long> {
	
}
