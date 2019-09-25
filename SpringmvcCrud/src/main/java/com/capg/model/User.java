package com.capg.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
@Pattern(regexp = "[A-Za-z0-9]{2,4}", message = "Invalid Name") 
private String name;
@Size(min=10,message="required")
private String mobile;
@Email@Size(min=1,message="invallid email")
private String email;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}



}
