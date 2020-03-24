package com.medicine_time.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.medicine_time.models.AllMedicine;
import com.medicine_time.services.AllMedicine.AllMedicineService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class AllMedicineController {
	
	private AllMedicineService am;
	
	@Autowired
	public AllMedicineController(AllMedicineService am) {
		this.am = am;
	}

	@GetMapping("/Medicine/View")
	@SuppressWarnings("rawtypes")
	public ResponseEntity viewAllMedicines(){
		return new ResponseEntity<List<AllMedicine>>(am.viewAllMedicines(),HttpStatus.OK);
	}


	//i dont think this has a link??
	@PostMapping("/Medicine/View/:ID")
	@SuppressWarnings("rawtypes")
	public ResponseEntity getOneMedicine(long id) {
		return new ResponseEntity<AllMedicine>(am.getOneMedicine(id),HttpStatus.OK);
	}
	
	
	@PatchMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity addToAllMedicine(AllMedicine am) {
		if(am.getId()!=0) {
			return new ResponseEntity<>("Medicine must be an input of 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AllMedicine>(this.am.updateAllMedicine(am),HttpStatus.OK);
	}
}