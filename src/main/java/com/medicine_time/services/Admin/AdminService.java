package com.medicine_time.services.Admin;

import com.medicine_time.models.Admin;

public interface AdminService {
	public Admin getAdminById(long id);
	public Admin saveAdmin(Admin admin);
}
