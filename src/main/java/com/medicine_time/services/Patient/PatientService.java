package com.medicine_time.services.Patient;

import com.medicine_time.models.Patient;

public interface PatientService {
	public Patient getPatientById(long id);
	public Patient saveDoctorToPatient(long patientId, long doctorId);
	public Patient savePatient(Patient patient);
}
