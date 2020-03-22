package com.revature.medicine_time.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
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
	
	@NotNull
	@Column(name="start_date")
	private int startDate;
	
	@NotNull
	@Column(name="end_date")
	private int endDate;
	
	
	
	
	
	
	
}
