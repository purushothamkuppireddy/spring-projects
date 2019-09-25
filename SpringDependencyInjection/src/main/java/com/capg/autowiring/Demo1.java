package com.capg.autowiring;

public class Demo1 {
	Demo d;
	String nm;
	String code;
	
	public Demo1(Demo d) {
		super();
		System.out.println("in demo1 1 para constructor");
		this.d = d;
		
	}


	public Demo1(Demo d, String nm,String code) {
		
		super();
		System.out.println("in demo1 3 para constructor");
		this.d = d;
		this.nm = nm;
		this.code=code;
	
	}
	
	
	public Demo1(Demo d, String nm) {
		super();
		this.d = d;
		this.nm = nm;
		System.out.println("in demo1 2 para constructor");
	}


	Demo1() {
		System.out.println("I am Demo1");
	}

	public void display() {
		System.out.println("Hello");
		System.out.println(nm);
		d.display();
		
	}

	public Demo getD() {
		return d;
	}

	public void setD(Demo d) {
		this.d = d;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

}
