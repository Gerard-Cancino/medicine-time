package com.medicine_time.services.Medication;

import java.util.List;

import com.medicine_time.models.Medication;

import java.util.Date;



public interface MedicationService {
	public List<Medication> getAllMedication();
	public Medication saveNewMedication(Medication m);
	public Medication getMedicationById(long id);
	public Medication updateMedication(Medication m);
	//Test From here 
	public Medication getStartDate(Date d);
	public Medication getEndDate(Date d);
	

}
