package com.api.petclinic.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AppointmentRequest {

	@NotBlank
	@Size(min = 3, max = 50)
	private String patientName;

	@NotBlank
	@Size(max = 50)
	@Email
	private String patientEmail;

	@NotBlank
	@Size(max = 10)
	@Pattern(regexp = "[0-9]{10}")
	private String patientMobile;

	@NotBlank
	@Size(min = 6, max = 150)
	private String specialization;

	@NotBlank
	@Size(min = 6, max = 50)
	private String doctorname;

	@NotBlank
	@Pattern(regexp = "((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])")
	private String appointmentDate;

	@NotBlank
	@Pattern(regexp = "([012345][0-9]|6[1-9]):([012345][0-9]|6[1-9]):([012345][0-9]|6[1-9])")
	private String appointmentTime;
	
	@NotBlank
	private String pettype;

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

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getPettype() {
		return pettype;
	}

	public void setPettype(String pettype) {
		this.pettype = pettype;
	}

}
