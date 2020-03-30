package com.medicine_time.controllers;
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

import com.medicine_time.models.AllMedicine;
import com.medicine_time.models.Medication;
import com.medicine_time.services.Medication.MedicationService;

@RestController 
@RequestMapping("medication")
@CrossOrigin
public class MedicationController {

	private MedicationService ms;
	
	
	@Autowired 
	public MedicationController(MedicationService ms) {
		this.ms = ms;
	}
	
	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity getAllMedication(){
		return new ResponseEntity<List<Medication>>(ms.getAllMedication(),HttpStatus.OK);
	}
	

	
	
	@PostMapping
	public ResponseEntity<Medication> saveNewMedication(@RequestBody Medication m){
		if(m.getId() != 0) {
			return new ResponseEntity("medicationId must be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(ms.saveNewMedication(m), HttpStatus.CREATED);
	}
	
	@PatchMapping
	public ResponseEntity<Medication> updateMovie(@RequestBody Medication m){// will try and turn the body into the object type on its right
		if(m.getId() == 0) {
			return new ResponseEntity("medicationId must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(ms.updateMedication(m), HttpStatus.CREATED);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Medication> getMedicationById(@PathVariable long id){// will try and turn the body into the object type on its right
		if(id== 0) {
			return new ResponseEntity("medicationId must not be 0", HttpStatus.BAD_REQUEST);
		}
		System.out.println("##WE ARE IN CONTROLLER##");
		System.out.print(ms.getMedicationById(id));
		return new ResponseEntity(ms.getMedicationById(id), HttpStatus.OK);
	}
	
	
	
}
