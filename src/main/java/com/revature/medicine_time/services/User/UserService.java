package com.revature.medicine_time.services.User;

import com.revature.medicine_time.models.User;

public interface UserService {
	public User login(String username, String password);
	public User updateUser(User user);
}
