package com.medicine_time.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Patient")
@Table(name="patient")
public class Patient extends User{
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="doctor_id",nullable=true)
	@JsonIgnore
	private Doctor doctor;
	@OneToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="patient_id",nullable=true)
	private List<Medication> medicationList;

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
