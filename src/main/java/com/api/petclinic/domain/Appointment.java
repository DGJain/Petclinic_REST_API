package com.api.petclinic.domain;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id long id;
	private String patientName;
	private String patientEmail;
	private String patientMobile;
	private String specialization;
	private String doctorname;

	private Date appointmentDate;
	private Date updatedOn;

	private Time appointmentTime;

	private String pettype;

	public long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Login))
			return false;
		Appointment appointment = (Appointment) o;
		return Objects.equals(patientName, appointment.patientName)
				&& Objects.equals(patientMobile, appointment.patientMobile);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, patientName, patientMobile);
	}

	@Override
	public String toString() {
		return "Login{" + "id=" + id + ", name='" + patientName + '\'' + ", mobile='" + patientMobile + '\'' + '}';
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Time getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getPettype() {
		return pettype;
	}

	public void setPettype(String pettype) {
		this.pettype = pettype;
	}

}
