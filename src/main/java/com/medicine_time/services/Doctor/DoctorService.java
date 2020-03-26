package com.medicine_time.services.Doctor;

import com.medicine_time.models.Doctor;

import java.util.List;

public interface DoctorService {
	public Doctor getDoctorById(long id);
	public boolean saveDoctorToPatient(long patientId,long doctorId);
	public List<Doctor> getDoctorList();

}
