package com.nt.arithmeticTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticServicetest2 {

	private static ArithmeticService service=null;
	@Rule
	public ExpectedException exception=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=new ArithmeticServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		service=null;
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void test() {

	exception.expect(IllegalArgumentException.class);
	exception.expectMessage("Invalid inputs");
	service.add(0, 0);
	fail("Invalid inputs");
	}

}
