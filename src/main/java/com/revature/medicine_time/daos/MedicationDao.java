package com.revature.medicine_time.daos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.medicine_time.models.Medication;


public interface MedicationDao extends JpaRepository<Medication, Long> {
}
