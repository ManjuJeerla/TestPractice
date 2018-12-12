package com.nt.arithmeticTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ArithmeticServiceTest {

	
	public int a;
	public int b;
	public ArithmeticServiceTest(int a, int b) {
		this.a = a;
		this.b = b;

	}

	private static ArithmeticService service = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new ArithmeticServiceImpl();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setup()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown()");
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data=new Object[][] {{-1,-45},{5,10},{120,350}};
		
		return Arrays.asList(data);

	}

	@Test
	public void addAlltest() {
		
		assertEquals("result",a+b, service.add(a, b));
		
		
	}

}
