package com.revature.medicine_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.medicine_time.models.Patient;
import com.revature.medicine_time.services.Patient.PatientService;

@RestController
@RequestMapping("patients")
@CrossOrigin
public class PatientController {
	private PatientService ps;
	
	@Autowired
	public PatientController(PatientService ps) {
		this.ps = ps;
	}
	
	@GetMapping("{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity getPatientById(@PathVariable long id){
		if(id==0) {
			return new ResponseEntity<>("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Patient>(ps.getPatientById(id),HttpStatus.OK);
	}
	
	@PatchMapping("{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity saveDoctorToPatient(@PathVariable long id, @RequestBody long doctorId){
		if(id==0 || doctorId==0) {
			return new ResponseEntity<>("Id or doctor id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Patient>(ps.saveDoctorToPatient(id, doctorId),HttpStatus.OK);
	}
}
