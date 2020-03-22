package com.revature.medicine_time.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.medicine_time.models.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor,Long>{}
