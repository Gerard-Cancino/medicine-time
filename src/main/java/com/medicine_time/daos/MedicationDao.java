package com.medicine_time.daos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.medicine_time.models.Medication;


public interface MedicationDao extends JpaRepository<Medication,Long> {

}
