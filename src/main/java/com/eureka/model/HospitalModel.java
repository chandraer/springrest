package com.eureka.model;



public class HospitalModel {
	private String name;
	private String location;
	private String rating;
	private String email;
	private String phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public HospitalModel(String name, String location, String rating, String email, String phoneNumber) {
		super();
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "HospitalModel [name=" + name + ", location=" + location + ", rating=" + rating + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
}
