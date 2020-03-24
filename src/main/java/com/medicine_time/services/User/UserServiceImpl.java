package com.medicine_time.services.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine_time.daos.AdminDao;
import com.medicine_time.daos.DoctorDao;
import com.medicine_time.daos.PatientDao;
import com.medicine_time.daos.UserBaseDao;
import com.medicine_time.daos.UserDao;
import com.medicine_time.dtos.UserLogin;
import com.medicine_time.models.Admin;
import com.medicine_time.models.User;

@Service
public class UserServiceImpl implements UserService<User>{
	
	private UserDao ud;
	
	@Autowired
	public UserServiceImpl(UserDao ud) {
		this.ud=ud;
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
	
	@Override
	public User login(String username, String password) {
		User u = ud.findByUsernameAndPassword(username, password);
		return u;
	}

}
