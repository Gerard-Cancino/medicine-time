package com.medicine_time.services.AllMedicine;

import com.medicine_time.models.AllMedicine;

public interface AllMedicineService {
    //services
    public AllMedicine viewAllMedicine();
    public AllMedicine getOneMedicine(long id);
    public AllMedicine updateUser(AllMedicine am);
}