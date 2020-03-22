package com.revature.medicine_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.medicine_time.models.User;
import com.revature.medicine_time.services.User.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
	
	private UserService us;
	
	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	
	//TODO 
	@PostMapping("login")
	@SuppressWarnings("rawtypes")
	public ResponseEntity login(String username, String password) {
		return new ResponseEntity<User>(us.login(username, password),HttpStatus.OK);
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
