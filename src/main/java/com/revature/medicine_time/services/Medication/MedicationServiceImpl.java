package com.revature.medicine_time.services.Medication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.medicine_time.daos.MedicationDao;
import com.revature.medicine_time.models.Medication;

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
		return md.getOne(id);
	}


//
//	@Override
//	public Medication updateMedication(Medication m) {
//		// TODO Auto-generated method stub
//		Medication oldMed = md.getOne(m.getMedicationId());
//		if(m.get)
//		
//		return oldMed;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
