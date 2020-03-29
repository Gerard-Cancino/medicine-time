package com.medicine_time.services.AllMedicine;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.medicine_time.daos.AllMedicineDao;
import com.medicine_time.models.AllMedicine;
import java.util.List;
import java.util.Optional;

@Service
public class AllMedicineServiceImpl implements AllMedicineService {

	private AllMedicineDao ad;

	@Autowired
	public AllMedicineServiceImpl(AllMedicineDao ad) {
		this.ad = ad;
	}

	@Override
	@JsonIgnore
	public List<AllMedicine> viewAllMedicines() {
		return ad.findAll();
	}

	@Override
	public AllMedicine addMedicine(AllMedicine addAm){
		return ad.save(addAm);
	}

	@Override
	public AllMedicine getOneMedicine(int id) {
		return ad.getOne(id);
	}

	@Override
	@Transactional
	public AllMedicine updateAllMedicine(AllMedicine am) {
		AllMedicine newAm = ad.getOne(0);
		if(am.getName()!="") {
			newAm.setName(am.getName());
		}
		if(am.getDescription()!="") {
			newAm.setDescription(am.getDescription());
		}
		return newAm;
	}

}