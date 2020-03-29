package main.java.com.medicine_time.services.AllMedicine;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

import com.medicine_time.daos.AllMedicineDao;
import com.medicine_time.models.AllMedicine;

@Service
public class AllMedicineImpl implements AllMedicineService{

	private AllMedicineDao ad;
    
    @Override
	public List<AllMedicine> viewAllMedicine() {
		return ad.findAll();
	}

	@Override
	public AllMedicine getOneMedicine(long id) {
		return ad.getOne(id);
	}

	@Override
	@Transactional
	public AllMedicine updateUser(AllMedicine am) {
		AllMedicine newAm = ad.getOne(am.getId());
		if(am.getName()!="") {
			newAm.setName(am.getName());
		}
		if(am.getDescription()!="") {
			newAm.setDescription(am.getDescription());
		}
		return newAm;
	}

	//fixing
	/**
	public AllMedicine addMedicine(AllMedicine am){
		AllMedicine newAm = am.getOne(am.getId());
		if(am.getName()!="") {
			newAm.setName(am.getName());
		}
		if(am.getDescription()!="") {
			newAm.setEmail(am.getDescription());
		}
		return newAm;
	}*/

}