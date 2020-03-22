package com.revature.medicine_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.medicine_time.models.Doctor;
import com.revature.medicine_time.services.Doctor.DoctorService;

@RestController
@RequestMapping("doctors")
@CrossOrigin
public class DoctorController {
	private DoctorService ds;
	@Autowired
	public DoctorController(DoctorService ds) {
		this.ds = ds;
	}
	
	@GetMapping("{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity getAdminById(@PathVariable long id){
		if(id==0) {
			return new ResponseEntity<>("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Doctor>(ds.getDoctorById(id),HttpStatus.OK);
	}
}
