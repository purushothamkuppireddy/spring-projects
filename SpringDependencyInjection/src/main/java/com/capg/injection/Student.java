package com.capg.injection;

public class Student {

	private String name;
	private String hNo;
	
	public Student(String name,String hNo)
	{
		super();
		this.name=name;
		this.hNo=hNo;
	}
	public Student()
	{}
	
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
