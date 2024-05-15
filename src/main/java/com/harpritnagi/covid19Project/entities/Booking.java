package com.harpritnagi.covid19Project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "booking", uniqueConstraints = @UniqueConstraint(columnNames = "phone"))
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid")
	private int bid;
	
	private String name;
	private String email;
	private String location;
	private String hospital;
	private String address;
	private String addressSecond;
	@NotBlank(message="Phone Number is mandatory")
	@Column(length = 10, unique = true)
	private String phone;
	
	@OneToOne(mappedBy = "booking")
	private User userone;
	
	
	public Booking() {
		super();
		
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressSecond() {
		return addressSecond;
	}
	public void setAddressSecond(String addressSecond) {
		this.addressSecond = addressSecond;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUserone() {
		return userone;
	}

	public void setUserone(User userone) {
		this.userone = userone;
	}

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", name=" + name + ", email=" + email + ", location=" + location + ", hospital="
				+ hospital + ", address=" + address + ", addressSecond=" + addressSecond + ", phone=" + phone
				+ ", userone=" + userone + "]";
	}
	
	
	
	
}
