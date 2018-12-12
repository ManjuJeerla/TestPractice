package com.nt.mockito;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.nt.dao.AuthenticateDAO;

public class AuthenticateTests {
	
	private static AuthenticateDAO mockDAO;
	private static AuthenticateService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//create mockDAO for DAO interface
		mockDAO=Mockito.mock(AuthenticateDAO.class);
		//set the mockDAO to service class object
		service=new AuthenticateServiceImpl();
		((AuthenticateServiceImpl) service).setAuthenticateDAO(mockDAO);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service=null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWithValidCredentials() {
		boolean status=false;
		
		//generate mockDAO result for verify method
		
		Mockito.when(mockDAO.validate("raja", "rani")).thenReturn(1);
		status = service.authenticate("raja","rani");
		assertTrue(status);
	}
	@Test
	public void testWithInvalidCredentials() {
		boolean status =false;
		//generate mockDAO result to verify the method
		
		Mockito.when(mockDAO.validate("raja", "rani1")).thenReturn(0);
		status=service.authenticate("raja", "rani1");
		assertFalse(status);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithNoCredentials() {
		boolean status=false;
		//generate mockDAO result for verify the method
		
		//Mockito.when(mockDAO.validate("","")).thenReturn(0);//not required
		status=service.authenticate("", "");
		fail("Error is expected");
		
	}
	
	
	
	

}
