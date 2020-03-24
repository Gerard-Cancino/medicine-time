package com.medicine_time.services.User;

import com.medicine_time.models.User;

public interface UserService<T extends User> {
	public T login(String username, String password);
	public T updateUser(User user);
}
