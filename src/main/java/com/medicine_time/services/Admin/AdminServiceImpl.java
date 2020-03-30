package com.medicine_time.services.Admin;

import org.springframework.stereotype.Service;

import com.medicine_time.daos.AdminDao;
import com.medicine_time.models.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	private AdminDao ad;

	AdminServiceImpl(AdminDao ad){
		this.ad=ad;
	}

	@Override
	public Admin getAdminById(long id) {
		// TODO Auto-generated method stub
		return ad.findById(id).orElse(null);
	}

	@Override
	public Admin saveAdmin(Admin admin){
		return ad.save(admin);
	}
	
}
