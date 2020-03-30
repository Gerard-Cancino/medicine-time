package com.medicine_time.controllers;

import com.medicine_time.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.medicine_time.models.Admin;
import com.medicine_time.services.Admin.AdminService;

@RestController
@RequestMapping("admins")
@CrossOrigin
public class AdminController {
	private AdminService as;
	@Autowired
	public AdminController(AdminService as) {
		this.as = as;
	}
	
	@GetMapping("{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity getAdminById(@PathVariable long id){
		if(id==0) {
			return new ResponseEntity<>("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		Admin admin = as.getAdminById(id);
		if(admin==null) {
			return new ResponseEntity<>("Could not find user", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}

	@PostMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity saveAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(as.saveAdmin(admin),HttpStatus.CREATED);
	}
}
