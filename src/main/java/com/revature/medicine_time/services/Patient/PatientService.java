package com.revature.medicine_time.services.Patient;

import com.revature.medicine_time.models.Patient;

public interface PatientService {
	public Patient getPatientById(long id);
	public Patient saveDoctorToPatient(long patientId, long doctorId);
}
