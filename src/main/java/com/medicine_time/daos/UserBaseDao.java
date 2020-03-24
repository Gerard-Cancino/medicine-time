package com.medicine_time.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.medicine_time.models.User;

@NoRepositoryBean
public interface UserBaseDao<T extends User> extends JpaRepository<T,Long>{
	public T findByUsernameAndPassword(String username, String password);
}
