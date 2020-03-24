package com.medicine_time.daos;

import javax.transaction.Transactional;

import com.medicine_time.models.User;

@Transactional
public interface UserDao extends UserBaseDao<User>{}
