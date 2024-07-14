package com.eureka.dto;

public class DataTransferObject {
public int id;
public String name;
public String location;
public String rating;
public int getId() {
	return id;
}
public void setId(int id) {
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
@Override
public String toString() {
	return "DataTransferObject [id=" + id + ", name=" + name + ", location=" + location + ", rating=" + rating + "]";
}

}
