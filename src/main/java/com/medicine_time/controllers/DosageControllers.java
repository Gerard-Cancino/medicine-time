package com.medicine_time.controllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine_time.models.Dosage;
import com.medicine_time.services.Dosage.DosageService;



@RestController 
@RequestMapping("/dosage")
@CrossOrigin
public class DosageControllers {
	@Autowired
private DosageService dg;
	
	public DosageControllers(DosageService dg) {
		this.dg = dg;
	}

	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity<List<Dosage>> getAllDosage(){
		
		return new ResponseEntity(dg.getAllDosage(), HttpStatus.OK);
	}
	
	@PostMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity<Dosage> saveNewDosage(@RequestBody Dosage d){
			if(d.getDosageId() != 0) {
			return new ResponseEntity("DosageId must be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Dosage>(dg.saveNewDosage(d), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity getDosageById(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		Dosage dosage = dg.getDosageById(id);
		if(dosage==null) {
			return new ResponseEntity<>("Could not find dosage",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Dosage>(dg.getDosageById(id), HttpStatus.OK);
	}

	
	@PatchMapping
	public ResponseEntity<Dosage> updateDosage(@RequestBody Dosage d){// will try and turn the body into the object type on its right
		if(d.getDosageId() == 0) {
			return new ResponseEntity("Dosage Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Dosage>(dg.updateDosage(d), HttpStatus.CREATED);
	}
	
	
}
