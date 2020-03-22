package com.revature.medicine_time.services.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.medicine_time.daos.DoctorDao;
import com.revature.medicine_time.daos.PatientDao;
import com.revature.medicine_time.models.Doctor;
import com.revature.medicine_time.models.Patient;

@Service
public class PatientServiceImpl implements PatientService{
	private PatientDao pd;
	private DoctorDao dd;
	
	@Autowired
	public PatientServiceImpl(PatientDao pd) {
		this.pd = pd;
	}
	
	@Override
	public Patient getPatientById(long id) {
		return pd.getOne(id);
	}
	
	@Override
	public Patient saveDoctorToPatient(long patientId, long doctorId) {
		Patient oldPatient = pd.getOne(patientId);
		Doctor doctor = dd.getOne(doctorId);
		oldPatient.setDoctor(doctor);
		return oldPatient;
	}
}
