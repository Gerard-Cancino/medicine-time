package com.revature.medicine_time.controllers;


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

import com.revature.medicine_time.models.Dosage;
import com.revature.medicine_time.services.Dosage.DosageService;
//import com.revature.medicine_time.services.Dosage;



@RestController // this is the same as @Controller and @responsebody above every method
@RequestMapping("/dosage")//base path for the class, 
@CrossOrigin//for doing cors on a per controller basis
public class DosageControllers {
	@Autowired
private DosageService dg;
	
	public DosageControllers(DosageService dg) {
		this.dg = dg;
	}

	@GetMapping//this is going to match GET on path /dosage
	//This methods purpose, is take a request and build a response from that request
	public ResponseEntity<List<Dosage>> getAllDosage(){
		
		return new ResponseEntity(dg.getAllDosage(), HttpStatus.OK);
	}
	
	@PostMapping// this matches post key word
	public ResponseEntity<Dosage> saveNewDosage(@RequestBody Dosage d){// will try and turn the body into the object type on its right
		if(d.getDosageId() != 0) {
			return new ResponseEntity("DosageId must be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Dosage>(dg.saveNewDosage(d), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")// how to do pathvariables in spring
	public ResponseEntity<Dosage> getDosageById(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity("Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Dosage>(dg.getDosageById(id), HttpStatus.OK);
	}

	
	@PatchMapping
	public ResponseEntity<Dosage> updateUser(@RequestBody Dosage d){// will try and turn the body into the object type on its right
		if(d.getDosageId() == 0) {
			return new ResponseEntity("userId must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Dosage>(dg.updateDosage(d), HttpStatus.CREATED);
	}
	
	
}
