package com.revature.medicine_time.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="patient")
public class Patient extends User{
	@ManyToOne
	@JoinColumn(name="doctor_id",nullable=false)
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
