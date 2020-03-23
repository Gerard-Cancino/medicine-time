package com.revature.medicine_time.services.Medication;

import java.util.List;
import java.util.Date;
import com.revature.medicine_time.models.Medication;



public interface MedicationService {
	public List<Medication> getAllMedication();
	public Medication saveNewMedication(Medication m);
	public Medication getMedicationById(int id);
	public Medication updateMedication(Medication m);
//	public Medication getStartDate(Date d);
//	public Medication getEndDate(Date d);
}
