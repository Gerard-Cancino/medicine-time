package com.medicine_time.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name="Doctor")
@Table(name="doctor")
public class Doctor extends User{
	@OneToMany(mappedBy="doctor",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Patient> patientList;

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
}
