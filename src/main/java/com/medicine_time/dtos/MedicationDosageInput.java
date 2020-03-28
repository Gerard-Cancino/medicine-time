package com.medicine_time.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MedicationDosageInput {
	
	@NotNull
	protected long medicationId;
	
	@NotNull
	private int patientId;
	
	@NotNull
	private int medicineId;
	
	private String doctorNote;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private  Date startDate;
	
	@NotNull
	private int days;
	
	@NotNull
	private int dosageDay;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + days;
		result = prime * result + ((doctorNote == null) ? 0 : doctorNote.hashCode());
		result = prime * result + dosageDay;
		result = prime * result + (int) (medicationId ^ (medicationId >>> 32));
		result = prime * result + medicineId;
		result = prime * result + patientId;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		MedicationDosageInput other = (MedicationDosageInput) obj;
		if (days != other.days)
			return false;
		if (doctorNote == null) {
			if (other.doctorNote != null)
				return false;
		} else if (!doctorNote.equals(other.doctorNote))
			return false;
		if (dosageDay != other.dosageDay)
			return false;
		if (medicationId != other.medicationId)
			return false;
		if (medicineId != other.medicineId)
			return false;
		if (patientId != other.patientId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicationDosageInput [medicationId=" + medicationId + ", patientId=" + patientId + ", medicineId="
				+ medicineId + ", doctorNote=" + doctorNote + ", startDate=" + startDate + ", days=" + days
				+ ", dosageDay=" + dosageDay + "]";
	}

	public MedicationDosageInput(@NotNull long medicationId, @NotNull int patientId, @NotNull int medicineId,
			String doctorNote, @NotNull Date startDate, @NotNull int days, @NotNull int dosageDay) {
		super();
		this.medicationId = medicationId;
		this.patientId = patientId;
		this.medicineId = medicineId;
		this.doctorNote = doctorNote;
		this.startDate = startDate;
		this.days = days;
		this.dosageDay = dosageDay;
	}

	/**
	 * @return the medicationId
	 */
	public long getMedicationId() {
		return medicationId;
	}

	/**
	 * @param medicationId the medicationId to set
	 */
	public void setMedicationId(long medicationId) {
		this.medicationId = medicationId;
	}

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the medicineId
	 */
	public int getMedicineId() {
		return medicineId;
	}

	/**
	 * @param medicineId the medicineId to set
	 */
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	/**
	 * @return the doctorNote
	 */
	public String getDoctorNote() {
		return doctorNote;
	}

	/**
	 * @param doctorNote the doctorNote to set
	 */
	public void setDoctorNote(String doctorNote) {
		this.doctorNote = doctorNote;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * @return the dosageDay
	 */
	public int getDosageDay() {
		return dosageDay;
	}

	/**
	 * @param dosageDay the dosageDay to set
	 */
	public void setDosageDay(int dosageDay) {
		this.dosageDay = dosageDay;
	}

	public MedicationDosageInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
