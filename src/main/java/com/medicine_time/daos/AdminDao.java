package com.medicine_time.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine_time.models.Admin;

@Transactional
public interface AdminDao extends UserBaseDao<Admin>{}
