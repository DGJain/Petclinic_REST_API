package com.api.petclinic.payload.response;

public class DoctorListResponse {
	private Long id;
	private String username;
	private String email;
	private String mobile;
	private String specialization;

	public DoctorListResponse(Long id, String username, String email, String mobile, String specialization) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.specialization = specialization;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
