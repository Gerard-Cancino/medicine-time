package com.medicine_time.daos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine_time.models.Medication;



public interface MedicationBaseDao <T extends Medication> extends JpaRepository<T,Long>{

}
