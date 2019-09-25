package com.capg.pack1;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student2 {

	private String name;
	private String hNo;
	Set<Address> addresses;
	
	public Student2(String name, String hNo, Set<Address> addresses) {
		super();
		this.name = name;
		this.hNo = hNo;
		this.addresses = addresses;
	}

	public Student2() {
		System.out.println("hello");
	}
	
//	private List<Address> addresses;
//	public Student2(String name, String hNo, List<Address> addresses) {
//		super();
//		this.name = name;
//		this.hNo = hNo;
//		this.addresses = addresses;
//	}
	
	
//	private Map<String,Address> addresses;
//	public Student2(String name, String hNo, Map<String, Address> addresses) {
//	super();
//	this.name = name;
//	this.hNo = hNo;
//	this.addresses = addresses;
//}
	
	
//	public Student2(String name,String hNo,Address address)
//	{
//		super();
//		this.name=name;
//		this.hNo=hNo;
//		this.address=address;
//	}
//	public Student2()
//	{}

//	public List<Address> getAddresses() {
//		return addresses;
//	}
//
//	public void setAddresses(List<Address> addresses) {
//		this.addresses = addresses;
//	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String gethNo() {
		return hNo;
	}

	public void sethNo(String hNo) {
		this.hNo = hNo;
	}

}
