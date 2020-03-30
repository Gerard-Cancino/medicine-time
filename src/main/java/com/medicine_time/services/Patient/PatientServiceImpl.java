package com.medicine_time.services.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine_time.daos.DoctorDao;
import com.medicine_time.daos.PatientDao;
import com.medicine_time.models.Doctor;
import com.medicine_time.models.Patient;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
		return pd.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Patient saveDoctorToPatient(long patientId, long doctorId) {
		Patient oldPatient = pd.getOne(patientId);
		System.out.println(oldPatient);
		Doctor doctor = dd.getOne(doctorId);
		if(oldPatient.getDoctor().getId()==doctor.getId()){
			oldPatient.setDoctor(null);
		}
		else{
			oldPatient.setDoctor(doctor);
		}
		pd.save(oldPatient);
		return oldPatient;
	}

	@Override
	public List<Patient> getPatientListByDoctorId(long doctorId){
		if(doctorId==0){
			return pd.findAllByDoctor(null);
		}
		return pd.findAllByDoctorId(doctorId);
	}
	
	@Override
	public Patient savePatient(Patient patient) {
		return pd.save(patient);
	}
}
