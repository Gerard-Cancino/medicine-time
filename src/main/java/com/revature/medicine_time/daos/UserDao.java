package com.revature.medicine_time.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.medicine_time.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	public User findByUsernameAndPassword(String username, String password);
}
