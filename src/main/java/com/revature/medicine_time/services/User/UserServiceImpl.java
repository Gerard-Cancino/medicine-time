package com.revature.medicine_time.services.User;

import org.springframework.stereotype.Service;

import com.revature.medicine_time.daos.UserDao;
import com.revature.medicine_time.models.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDao ud;
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User u) {
		User oU = ud.getOne(u.getId());
		if(u.getDateOfBirth()!=0) {
			oU.setDateOfBirth(u.getDateOfBirth());
		}
		if(u.getEmail()!="") {
			oU.setEmail(u.getEmail());
		}
		if(u.getFirstName()!="") {
			oU.setFirstName(u.getFirstName());
		}
		if(u.getLastName()!="") {
			oU.setLastName(u.getLastName());
		}
		if(u.getPassword()!="") {
			oU.setPassword(u.getPassword());
		}
		if(u.getPhoneNumber()!=0) {
			oU.setPhoneNumber(u.getPhoneNumber());
		}
		return oU;
	}

}
