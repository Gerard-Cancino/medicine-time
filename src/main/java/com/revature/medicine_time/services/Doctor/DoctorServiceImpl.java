package com.revature.medicine_time.services.Doctor;

import org.springframework.stereotype.Service;

import com.revature.medicine_time.daos.DoctorDao;
import com.revature.medicine_time.models.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
	private DoctorDao dd;
	
	public DoctorServiceImpl(DoctorDao dd) {
		this.dd = dd;
	}
	
	@Override
	public Doctor getDoctorById(long id) {
		return dd.getOne(id);
	}
	
	@Override
	public boolean saveDoctorToPatient(long patientId, long doctorId) {
		// TODO
		return false;
	}
	
}
