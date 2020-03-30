package com.medicine_time.services.Medication;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine_time.daos.MedicationDao;
import com.medicine_time.models.Medication;

@Service
public class MedicationServiceImpl implements MedicationService{
	
	private MedicationDao md;
	
	
	
	@Autowired
	public MedicationServiceImpl(MedicationDao md) {
		
		this.md = md; 
		
	}



	@Override
	public List<Medication> getAllMedication() {
		// TODO Auto-generated method stub
		return md.findAll();
	}



	@Override
	public Medication saveNewMedication(Medication m) {
		// TODO Auto-generated method stub
		return md.save(m);
	}



	@Override
	public Medication getMedicationById(long id) {
		// TODO Auto-generated method stub
		System.out.println("## WE ARE IN MEDICATION SERVICE ##");
		System.out.println(md.findById(id));
		return md.findById(id).orElse(null);
	}



	@Override
	public Medication updateMedication(Medication m) {
		// TODO Auto-generated method stub
		Medication oldMed = md.getOne(m.getId());
		if(m.getDoctorNote() != "") {
			oldMed.setDoctorNote(m.getDoctorNote());
		}
		if(m.getStartDate() != null) {
			oldMed.setStartDate(m.getStartDate());
		}/*
		if(m.getEndDate() != null) {
			oldMed.setEndDate(m.getEndDate());
		}*/
		
		return oldMed;
		}



	@Override
	public Medication getStartDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Medication getEndDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}



}

