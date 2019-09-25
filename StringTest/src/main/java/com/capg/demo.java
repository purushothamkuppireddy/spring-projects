package com.capg;

public class demo {

	public int length(String s1)
	{
		
		return s1.length();
		
	}
	public  boolean comp(String s1, String s2) {
		boolean i = s1.equalsIgnoreCase(s2);
		return i;

	}

	  String rev(String s1) {
		String reverse = "";
StringBuffer sb=new StringBuffer(s1);
return sb.reverse().toString();
//		for (int i = s1.length() - 1; i >= 0; i--) {
//			reverse = reverse + s1.charAt(i);
//		}
//
//		System.out.println("Reversed string is:");
//		System.out.println(reverse);
//		return reverse;

	}
	
}
