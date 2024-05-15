package com.harpritnagi.covid19Project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	@NotBlank(message = "Name field is required")
	private String yourEmail;
	@Column(length = 500)
	private String yourFeedback;
	
	
	@ManyToOne()
	private User usermany;
	
	public Feedback() {
		super();
		
	}
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getYourEmail() {
		return yourEmail;
	}
	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}
	public String getYourFeedback() {
		return yourFeedback;
	}
	public void setYourFeedback(String yourFeedback) {
		this.yourFeedback = yourFeedback;
	}

	public User getUsermany() {
		return usermany;
	}

	public void setUsermany(User usermany) {
		this.usermany = usermany;
	}







}
