package com.hla.ficheservice.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hla.ficheservice.model.Absence;
import com.hla.ficheservice.model.Employe;
import com.hla.ficheservice.model.Enfant;
import com.hla.ficheservice.repo.AbsenceRepository;
import com.hla.ficheservice.repo.EmployeRepository;
import com.hla.ficheservice.repo.EnfantRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AbsenceController {

	@Autowired
	private AbsenceRepository absenceRepository;
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	
	@GetMapping("/absences")
	public List<Absence> getAllAbsences() {
		
		System.out.println("Recuperer toutes les fiches des absences...");

		List<Absence> absences = new ArrayList<>();
		absenceRepository.findAll().forEach(absences::add);
	
		return absences;
	}

	
	@GetMapping(value = "/absences/enfant")
	public List<Absence> findByEnfantPrenom(@RequestParam String prenom,@RequestParam String nom) {
		
		List<Absence> enfants = absenceRepository.findByEnfantPrenomAndEnfantNom(prenom,nom);
		return enfants;
	}

	
	
	@PostMapping(value = "/absence/create")	
	public Absence postAbsence(@RequestBody Absence absence,
			@RequestParam(name = "nom_enfant") String nomEnfant,
			@RequestParam(name = "prenom_enfant") String prenomEnfant) {
		
		Absence _absence= new Absence();
		Enfant enfant = enfantRepository.findByNomAndPrenom(nomEnfant,prenomEnfant).get(0);
		Long editeurId=0L;
		Optional<Employe> editeur = employeRepository.findById(editeurId); 		// The id value is hard-coded at the moment 
																	// the id value should be got from the connected user table once the security is deployed
		if(!editeur.isPresent())
			System.out.println("Pas d'employe sous l'id :"+editeurId);
		else
			_absence = absenceRepository.save(new Absence(enfant,editeur.get(),absence.getDateAbsence(),
					absence.getDateReprise(),absence.getRaison(),absence.getCommentaire()));;
		return _absence;
	} 
}