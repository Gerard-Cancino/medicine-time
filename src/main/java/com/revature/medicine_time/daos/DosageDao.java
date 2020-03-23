package com.revature.medicine_time.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.medicine_time.models.Dosage;

@Repository
public interface DosageDao extends JpaRepository<Dosage,Integer>{
	
}
