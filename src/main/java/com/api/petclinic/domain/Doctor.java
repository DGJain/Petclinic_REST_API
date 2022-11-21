package com.api.petclinic.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id long id;
	private String name;
	private String email;
	private String mobile;
	private String specialization;

	private Date updatedOn;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Login))
			return false;
		Doctor doctor = (Doctor) o;
		return Objects.equals(name, doctor.name) && Objects.equals(specialization, doctor.specialization);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, specialization);
	}

	@Override
	public String toString() {
		return "Login{" + "id=" + id + ", name='" + name + '\'' + ", specialization='" + specialization + '\'' + '}';
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
