package com.medicine_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<Admin>(as.getAdminById(id),HttpStatus.OK);
	}
}
