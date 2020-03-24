package com.medicine_time.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine_time.models.AllMedicine;

@Repository
public interface AllMedicine extends JpaRepository<AllMedicine, Long>{
}
