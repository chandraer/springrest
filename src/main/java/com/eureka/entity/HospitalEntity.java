package com.eureka.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class HospitalEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
private String location;
private String rating;
@CreatedDate
private LocalDateTime createdAt;
@CreatedBy
private String createdBy;
private String email;
private String phoneNumber;
//public HospitalEntity(Long id, String name, String location, double rating, LocalDateTime createdAt, String createdBy,
//		String email, String phoneNumber) {
//	super();
//	this.id = id;
//	this.name = name;
//	this.location = location;
//	this.rating = rating;
//	this.createdAt = createdAt;
//	this.createdBy = createdBy;
//	this.email = email;
//	this.phoneNumber = phoneNumber;
//}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
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
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
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
@Override
public String toString() {
	return "HospitalEntity [id=" + id + ", name=" + name + ", location=" + location + ", rating=" + rating
			+ ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", email=" + email + ", phoneNumber="
			+ phoneNumber + "]";
}

}
