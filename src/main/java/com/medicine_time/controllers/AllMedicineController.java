package com.medicine_time.controllers;

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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.medicine_time.models.AllMedicine;
import com.medicine_time.services.AllMedicine.AllMedicineService;

@RestController
@RequestMapping("Medicine")
@CrossOrigin
public class AllMedicineController {
	
	private AllMedicineService am;
	
	@Autowired
	public AllMedicineController(AllMedicineService am) {
		this.am = am;
	}

	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity viewAllMedicines(){
		return new ResponseEntity<List<AllMedicine>>(am.viewAllMedicines(),HttpStatus.OK);
	}


	@GetMapping("{id}")
	public ResponseEntity getOneMedicine(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity("Id must not be < 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AllMedicine>(am.getOneMedicine(id),HttpStatus.OK);
	}
	
	@PostMapping()
	@SuppressWarnings("rawtypes")
	public ResponseEntity addMedicine(@RequestBody AllMedicine addAm) {
		return new ResponseEntity<AllMedicine>(am.updateAllMedicine(addAm),HttpStatus.OK);
	}
	
	
	@PatchMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity updateMedicine(@RequestBody AllMedicine am) {
		if(am.getId()!=0) {
			return new ResponseEntity<>("Medicine must be an input of 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AllMedicine>(this.am.updateAllMedicine(am),HttpStatus.OK);
	}
}