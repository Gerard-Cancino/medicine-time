package com.medicine_time.services.AllMedicine;

import com.medicine_time.models.AllMedicine;
import java.util.List;

public interface AllMedicineService {
    //services
    public List<AllMedicine> viewAllMedicines();
    public AllMedicine getOneMedicine(int id);
    public AllMedicine updateAllMedicine(AllMedicine am);
    public AllMedicine addMedicine(AllMedicine am);
}