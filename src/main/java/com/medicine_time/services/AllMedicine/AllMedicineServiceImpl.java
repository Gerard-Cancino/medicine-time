package com.medicine_time.services.AllMedicine;

import org.springframework.stereotype.Service;

import com.medicine_time.daos.AllMedicineDao;
import com.medicine_time.models.AllMedicine;

@Service
public class AllMedicineServiceImpl implements AllMedicineService{

	private AllMedicineDao am;
	
	@Autowired
	public DoctorServiceImpl(DoctorDao am) {
		this.am = am;
	}

    @Override
	public List<AllMedicine> viewAllMedicine() {
		return am.findAll();
	}

	@Override
	public AllMedicine getOneMedicine(long id) {
		return am.getOne(id);
	}

	@Override
	@Transactional
	public AllMedicine updateUser(AllMedicine am) {
		AllMedicine newAm = am.getOne(am.getId());
		if(am.getName()!="") {
			newAm.setName(am.getName());
		}
		if(am.getDescription()!="") {
			newAm.setEmail(am.getEmail());
		}
		return newAm;
	}

}