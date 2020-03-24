package com.medicine_time.services.Admin;

import org.springframework.stereotype.Service;

import com.medicine_time.daos.AdminDao;
import com.medicine_time.models.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	private AdminDao ad;
	
	@Override
	public Admin getAdminById(long id) {
		// TODO Auto-generated method stub
		return ad.getOne(id);
	}
	
}
