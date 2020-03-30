package com.medicine_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine_time.dtos.Credentials;
import com.medicine_time.models.Admin;
import com.medicine_time.models.Doctor;
import com.medicine_time.models.Patient;
import com.medicine_time.models.User;
import com.medicine_time.services.Admin.AdminService;
import com.medicine_time.services.Doctor.DoctorService;
import com.medicine_time.services.Patient.PatientService;
import com.medicine_time.services.User.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
	
	private UserService us;
	private AdminService as;
	private DoctorService ds;
	private PatientService ps;
	
	@Autowired
	public UserController(UserService us,AdminService as,DoctorService ds, PatientService ps) {
		this.us = us;
		this.as = as;
		this.ds = ds;
		this.ps = ps;
	}
	

	@PostMapping("login")
	@SuppressWarnings("rawtypes")
	public ResponseEntity login(@RequestBody Credentials cred) {
		System.out.println(cred);
		User u = us.login(cred.getUsername(), cred.getPassword());
		if(u.getRoleType()=="Admin") {
			return new ResponseEntity<Admin>(as.getAdminById(u.getId()),HttpStatus.OK);
		}
		else if(u.getRoleType()=="Doctor") {
			return new ResponseEntity<Doctor>(ds.getDoctorById(u.getId()),HttpStatus.OK);
		}
		else if(u.getRoleType()=="Patient") {
			return new ResponseEntity<Patient>(ps.getPatientById(u.getId()),HttpStatus.OK);
		}
		return new ResponseEntity<User>(us.login(cred.getUsername(), cred.getPassword()),HttpStatus.OK);
	}
	
	@PatchMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity updateUser(User user) {
		if(user.getId()==0) {
			return new ResponseEntity<>("User cannot be an input of 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(us.updateUser(user),HttpStatus.OK);
	}
}
