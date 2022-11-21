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

@Entity(name = "feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id long id;
	private String name;
	private String email;
	private String mobile;
	private String review;

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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Login))
			return false;
		Feedback feedback = (Feedback) o;
		return Objects.equals(name, feedback.name) && Objects.equals(review, feedback.review);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, review);
	}

	@Override
	public String toString() {
		return "Login{" + "id=" + id + ", name='" + name + '\'' + ", review='" + review + '\'' + '}';
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
