package com.capg;

import static org.junit.Assert.*;

import org.junit.Test;

public class demoTest {

	demo d=new demo();
	@Test
	public void testLength() {
		assertEquals(5,d.length("hello"));
	}
	@Test
	public void testcomp() {
		assertEquals(false,d.comp("hello","sai"));
	}
	@Test
	public void testrev() {
		assertEquals(" ol leh",d.rev("hel lo "));
	}

}
