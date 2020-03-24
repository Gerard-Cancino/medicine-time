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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dosage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dosage_id")
	private int dosageId;
	
	@Column(name = "date")
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	 private  Date date;
	
	@Column(name = "time")
	@NotNull
	@JsonFormat(pattern="HH:mm")
	 private  Date time;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="medicationId")
	private Medication medication;
	
	@Column(name="status_id")
	@NotNull
	private int statusId;
	
	@Column(name="status_type")
	private String statusType;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public Dosage(int dosageId, @NotNull Date date, @NotNull Date time, Medication medication, @NotNull int statusId,
			String statusType) {
		super();
		this.dosageId = dosageId;
		this.date = date;
		this.time = time;
		this.medication = medication;
		this.statusId = statusId;
		this.statusType = statusType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + dosageId;
		result = prime * result + ((medication == null) ? 0 : medication.hashCode());
		result = prime * result + statusId;
		result = prime * result + ((statusType == null) ? 0 : statusType.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
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
		if (medication == null) {
			if (other.medication != null)
				return false;
		} else if (!medication.equals(other.medication))
			return false;
		if (statusId != other.statusId)
			return false;
		if (statusType == null) {
			if (other.statusType != null)
				return false;
		} else if (!statusType.equals(other.statusType))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dosage [dosageId=" + dosageId + ", date=" + date + ", time=" + time + ", medication=" + medication
				+ ", statusId=" + statusId + ", statusType=" + statusType + "]";
	}

	
}