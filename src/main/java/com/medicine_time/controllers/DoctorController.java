package com.medicine_time.controllers;

import com.medicine_time.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.medicine_time.models.Doctor;
import com.medicine_time.services.Doctor.DoctorService;

import java.util.List;

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
	public ResponseEntity getDoctorById(@PathVariable long id){
		if(id==0) {
			return new ResponseEntity<>("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Doctor>(ds.getDoctorById(id),HttpStatus.OK);
	}
	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity getDoctorList(){
		return new ResponseEntity<List<Doctor>>(ds.getDoctorList(),HttpStatus.OK);
	}

	@PostMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity savePatient(@RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(ds.saveDoctor(doctor),HttpStatus.OK);
	}
}
