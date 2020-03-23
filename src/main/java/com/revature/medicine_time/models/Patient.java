package com.revature.medicine_time.models;

import java.util.List;

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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doctor_id",nullable=false)
	private Doctor doctor;
	@OneToMany
	@JoinColumn(name="medication_id",nullable=false)
	private List<Medication> medication;

	public List<Medication> getMedication() {
		return medication;
	}

	public void setMedication(List<Medication> medication) {
		this.medication = medication;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
