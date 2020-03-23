package com.revature.medicine_time.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity(name="medication")
public class Medication {
	/*List of things needed user_id, medicine_id, doctor_note, start_date, end_date,
	 * medication_id  */
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="medication_id")
	protected long medicationId;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User userId;
	
	
	@OneToMany
	@JoinColumn(name="medicine_id",nullable=false)
	private AllMedicine medicineId;
	
	
	@Column(name="doctor_note")
	private String doctorNote;
	
	@Column(name = "start_date")
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	 private  Date startDate;
	
	@Column(name = "end_date")
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	 private  Date endDate;

	public long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(long medicationId) {
		this.medicationId = medicationId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public AllMedicine getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(AllMedicine medicineId) {
		this.medicineId = medicineId;
	}

	public String getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(String doctorNote) {
		this.doctorNote = doctorNote;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	
	
	
}
