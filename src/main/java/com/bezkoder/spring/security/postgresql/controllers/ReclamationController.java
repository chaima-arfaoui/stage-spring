package com.bezkoder.spring.security.postgresql.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bezkoder.spring.security.postgresql.models.Reclamation;
import com.bezkoder.spring.security.postgresql.models.Ticket;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.repository.ReclamationRepository;
import com.bezkoder.spring.security.postgresql.security.services.ReclamationService;

@CrossOrigin("*")
@RequestMapping("/api/reclamations")
@RestController

public class ReclamationController {
	@Autowired
	private ReclamationService reclamationservice;

	/*
	 * @GetMapping(value = "/reclamation") private List<Reclamation>
	 * reclamationliste(){ return reclamationservice.getreclamation(); }
	 */

	@GetMapping("/")
	public List<Reclamation> GetAll() {
		return reclamationservice.getreclamation();
	}

	@GetMapping(value = "/{id}")
	private Reclamation getreclamation(@PathVariable(name = "id") long id) {
		return reclamationservice.getreclamation(id);
	}

	@PostMapping()
	public ResponseEntity<?> addNewReclamation(@Validated @RequestBody Reclamation reclamation) {
		System.out.println(reclamation.getType());
		System.out.println("---------------------------------------------------------------");
		Reclamation newReclamation = reclamationservice.addNewReclamation(reclamation);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newReclamation.getId()).toUri();
		return ResponseEntity.created(location).body(newReclamation);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reclamation> UpdateReclamation(@PathVariable(name = "id") long id, @RequestBody Reclamation R) {
		 
				Reclamation reclamation = reclamationservice.UpdateReclamation(id, R);
				return ResponseEntity.ok(reclamation);
				
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteReclamation(@PathVariable(name = "id") long id) {
		reclamationservice.DeleteReclamartion(id);
		return ResponseEntity.ok("Reclamation supprimée avec succès");
	}

}