package com.medicine_time.services.Dosage;


import java.util.List;

import com.medicine_time.models.Dosage;

public interface DosageService {
	public List<Dosage> getAllDosage();
	public Dosage saveNewDosage(Dosage d);
	public Dosage getDosageById(int id);
	public Dosage updateDosage(Dosage d);
	public List<Dosage> getDosageByDate(Dosage d);
}
