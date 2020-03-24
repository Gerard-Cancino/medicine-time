package com.medicine_time.services.AllMedicine;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Transactional;
import com.medicine_time.daos.AllMedicineDao;
import com.medicine_time.models.AllMedicine;
import com.medicine_time.services.AllMedicineService;
import java.util.List;

@Service
public class AllMedicineServiceImpl implements AllMedicineService{

	private AllMedicineDao ad;
	
	@Autowired
	public AllMedicineServiceImpl(AllMedicineDao am) {
		this.ad = ad;
	}

    @Override
	public List<AllMedicine> viewAllMedicine() {
		return ad.viewAllMedicine();
	}

	@Override
	public AllMedicine getOneMedicine(long id) {
		return ad.getOneMedicine(id);
	}

	@Override
	@Transactional
	public AllMedicine updateAllMedicine(AllMedicine am) {
		AllMedicine newAm = ad.getOneMedicine(am.getId());
		if(am.getName()!="") {
			newAm.setName(am.getName());
		}
		if(am.getDescription()!="") {
			newAm.setDescription(am.getDescription());
		}
		return newAm;
	}

}