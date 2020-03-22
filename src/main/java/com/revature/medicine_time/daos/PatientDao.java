package com.revature.medicine_time.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.medicine_time.models.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long>{}
