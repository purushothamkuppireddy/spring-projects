package com.example.model;

import javax.validation.constraints.Size;

public class User {
	
 private String name;
 @Size(min=2,message="required")
 private String mobile;
 private String address;
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 
 
}
