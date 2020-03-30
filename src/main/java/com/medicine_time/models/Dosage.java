package com.medicine_time.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="dosage")
public class Dosage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dosage_id")
	private int dosageId;
	
	@Column(name = "date")
	@NotNull
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	 private  Date date;
	


	/*@JsonIdentityInfo(
			generator= ObjectIdGenerators.PropertyGenerator.class,
			property="id"
			)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	//@JsonIdentityReference(alwaysAsId = true)*/
	@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="medicationId")
	//@JsonIgnore
	//@Column (name= "medication_id")
	@JsonBackReference
	@NotNull
	private Medication medicationId;



	public Dosage() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getDosageId() {
		return dosageId;
	}



	public void setDosageId(int dosageId) {
		this.dosageId = dosageId;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Medication getMedicationId() {
		return medicationId;
	}



	public void setMedicationId(Medication medicationId) {
		this.medicationId = medicationId;
	}



	public Dosage(int dosageId, @NotNull Date date, Medication medicationId) {
		super();
		this.dosageId = dosageId;
		this.date = date;
		this.medicationId = medicationId;
	}



	@Override
	public String toString() {
		return "Dosage [dosageId=" + dosageId + ", date=" + date + ", medicationId=" + medicationId + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dosage other = (Dosage) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dosageId != other.dosageId)
			return false;
		if (medicationId != other.medicationId)
			return false;
		return true;
	}


	


	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "id", nullable = false)
	private User id;	*/
}