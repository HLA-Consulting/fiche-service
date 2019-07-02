package com.hla.ficheservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hla.ficheservice.model.Enfant;
import com.hla.ficheservice.repo.EnfantRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FicheController {

	@Autowired
	EnfantRepository repository;

	@GetMapping("/enfants")
	public List<Enfant> getAllEnfants() {
		System.out.println("Recuperer toutes les fiches des enfants...");

		List<Enfant> enfants = new ArrayList<>();
		repository.findAll().forEach(enfants::add);

		return enfants;
	}

	@PostMapping(value = "/enfants/create")
	public Enfant postEnfant(@RequestBody Enfant enfant) {

		Enfant _enfant = repository.save(new Enfant("Ramzi", "Oueslati"));
		return _enfant;
	}

	@DeleteMapping("/enfants/{id}")
	public ResponseEntity<String> deleteEnfant(@PathVariable("id") long id) {
		System.out.println("Supprimer un enfant ayant l'ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("L'enfant est bien supprimé!", HttpStatus.OK);
	}

	@DeleteMapping("/enfants/delete")
	public ResponseEntity<String> deleteAllEnfants() {
		System.out.println("Suppression de tous les fiches enfants...");

		repository.deleteAll();

		return new ResponseEntity<>("Toutes les fiches des enfants ont été supprimées!", HttpStatus.OK);
	}

	@GetMapping(value = "enfants/prenom/{prenom}")
	public List<Enfant> findByPrenom(@PathVariable String prenom) {

		List<Enfant> enfants = repository.findByPrenom(prenom);
		return enfants;
	}

	@PutMapping("/enfants/{id}")
	public ResponseEntity<Enfant> updateEnfant(@PathVariable("id") long id, @RequestBody Enfant enfant) {
		System.out.println("Mise a jour Enfant ayant l'ID = " + id + "...");

		Optional<Enfant> enfantData = repository.findById(id);

		if (enfantData.isPresent()) {
			Enfant _enfant = enfantData.get();
			_enfant.setNom(enfant.getNom());
			_enfant.setPrenom(enfant.getPrenom());
			_enfant.setActive(enfant.isActive());
			return new ResponseEntity<>(repository.save(_enfant), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
