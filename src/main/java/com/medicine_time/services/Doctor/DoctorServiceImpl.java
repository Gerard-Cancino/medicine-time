package com.medicine_time.services.Doctor;

import org.springframework.stereotype.Service;

import com.medicine_time.daos.DoctorDao;
import com.medicine_time.models.Doctor;

import java.util.List;

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
    @Override
	public List<Doctor> getDoctorList(){
		return dd.findAll();
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return dd.save(doctor);
	}
}
