package com.medicine_time.daos;

import javax.transaction.Transactional;

import com.medicine_time.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine_time.models.Patient;

import java.util.List;

@Transactional
public interface PatientDao extends UserBaseDao<Patient>{
    public List<Patient> findAllByDoctorId(Long doctorId);
    public List<Patient> findAllByDoctor(Doctor doctor);
}
