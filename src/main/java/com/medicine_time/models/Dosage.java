package com.medicine_time.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;

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
	
	@Column(name="medecation_id")
	@NotNull 
	//@JoinColumn(name="medication_id")
	private int medecationId;
	
	@Column(name="status_id")
	@NotNull
	private int statusId;
	
	@Column(name="status_type")
	private String statusType;

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

	public int getMedecationId() {
		return medecationId;
	}

	public void setMedecationId(int medecationId) {
		this.medecationId = medecationId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + dosageId;
		result = prime * result + medecationId;
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
		if (medecationId != other.medecationId)
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

	public Dosage(int dosageId, @NotNull Date date, @NotNull Date time, @NotNull int medecationId,
			@NotNull int statusId, String statusType) {
		super();
		this.dosageId = dosageId;
		this.date = date;
		this.time = time;
		this.medecationId = medecationId;
		this.statusId = statusId;
		this.statusType = statusType;
	}

	public Dosage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dosage [dosageId=" + dosageId + ", date=" + date + ", time=" + time + ", medecationId=" + medecationId
				+ ", statusId=" + statusId + ", statusType=" + statusType + "]";
	}
	

}