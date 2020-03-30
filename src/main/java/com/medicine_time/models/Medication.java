package com.medicine_time.models;




import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name="medication")
public class Medication implements Serializable{
	/*List of things needed user_id, medicine_id, doctor_note, start_date, end_date,
	 * medication_id  */
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column
	protected long id;
	  @OneToMany
	   @JoinColumn(name = "medicationId")
	  @GeneratedValue(strategy=GenerationType.AUTO)
		//@JsonIgnore

	  private List<Dosage> medicationId = new ArrayList<Dosage>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull
	@JoinColumn(name="patient_id",nullable=false)
	private Patient patientId;

	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull
	@JoinColumn(name="medicine_id",nullable=false)
	private AllMedicine medicineId;
	
	@Column(name="doctor_note")
	private String doctorNote;
	
	@Column(name = "start_date")
	@NotNull
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private  Date startDate;

	@Column(name = "end_date")
	@NotNull
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private  Date endDate;

	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patient) {
		this.patientId = patient;
	}
	public List<Dosage> getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(List<Dosage> medicationId) {
		this.medicationId = medicationId;
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

	public Medication(long id, List<Dosage> medicationId, @NotNull AllMedicine medicineId, String doctorNote,
			@NotNull Date startDate) {
		super();
		this.id = id;
		this.medicationId = medicationId;
		this.medicineId = medicineId;
		this.doctorNote = doctorNote;
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Medication [id=" + id + ", medicationId=" + medicationId + ", medicineId=" + medicineId
				+ ", doctorNote=" + doctorNote + ", startDate=" + startDate + "]";
	}


	

	
}
