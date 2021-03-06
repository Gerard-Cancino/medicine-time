package com.medicine_time.services.Dosage;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine_time.daos.DosageDao;
import com.medicine_time.models.Dosage;


@Service
public class DosageServiceImpl implements DosageService{
	private DosageDao dd;
	
	@Autowired
	public DosageServiceImpl(DosageDao dd) {
		this.dd=dd;
	}
	
	@Override
	public List<Dosage> getAllDosage(){
		return dd.findAll();
	}
	
	@Override
	public Dosage saveNewDosage(Dosage d){
		return dd.save(d);
	}
	@Override
	public Dosage getDosageById(int dosageId) {
		Dosage dosage = dd.findById(dosageId).orElse(null);
		if(dosage==null) {
			System.out.print("This dosage is null");
		}
		System.out.println("###############WE ARE IN SERVICE################");
		System.out.println(dosage);
		System.out.println("did this run?");
		return dosage;
	}
	
	@Override
	public List<Dosage> getDosageByDate(Dosage d) {
		return dd.findAll();
	}
	
	@Override
	@Transactional
	public Dosage updateDosage(Dosage d) {
	Dosage oldDosage = dd.getOne(d.getDosageId());
	if (d.getDate() !=null) {
		oldDosage.setDate(d.getDate());
	}
	return oldDosage;

	}

}
