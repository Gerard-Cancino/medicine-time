package com.revature.medicine_time.services.Doctor;

import com.revature.medicine_time.models.Doctor;

public interface DoctorService {
	public Doctor getDoctorById(long id);
	public boolean saveDoctorToPatient(long patientId,long doctorId);
}
