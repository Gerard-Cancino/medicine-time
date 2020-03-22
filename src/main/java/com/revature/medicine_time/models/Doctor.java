package com.revature.medicine_time.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="doctor")
public class Doctor extends User{
	@OneToMany(mappedBy="doctor")
	private List<Patient> patientList;

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
}
