package com.nt.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AllTests1 {

	private static BankLoanService service = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.out.println("BankLoanService::setBeforeClass()");
		service = new BankLoanServiceImpl();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("BankLoanService::tearDownClass()");
		service = null;

	}

	@Before
	public void setUp() throws Exception {

		System.out.println("Before::setUp()");

	}

	@After
	public void tearDown() throws Exception {

		System.out.println("After::tearDown()");
	}

	@Test
	public void bankLoanServiceWithSmallValues() {
		float pAmt = 10000.0f;
		float time = 2.0f;
		float rate = 12.0f;
		assertEquals("intrAmt", 2400.0f, service.calcSimpeIntrAmt(pAmt, time, rate), 0.0f);
	}

	@Test
	public void bankLoanServiceWithBigValues() {
		float pAmt = 1000000.0f;
		float time = 2.0f;
		float rate = 24.0f;
		assertEquals("intrAmt", 480000.0f, service.calcSimpeIntrAmt(pAmt, time, rate), 0.1f);
	}

	@Test(expected = IllegalArgumentException.class, timeout = 5000)
	public void bankLoanServiceWithZeroValues() {
		float pAmt = 0.0f;
		float time = 0.0f;
		float rate = 0.0f;
		assertEquals("intrAmt", 0.0f, service.calcSimpeIntrAmt(pAmt, time, rate), 0.0f);
		fail("Exception is expected");
	}

	

}
