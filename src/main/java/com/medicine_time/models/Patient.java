package com.medicine_time.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name="Patient")
@Table(name="patient")
public class Patient extends User{
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private Doctor doctor;
	
	@OneToMany(mappedBy="patientId",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Medication> medicationList;//=new ArrayList<Medication>();

	public List<Medication> getMedication() {
		return medicationList;
	}

	public void setMedication(List<Medication> medication) {
		this.medicationList = medication;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
