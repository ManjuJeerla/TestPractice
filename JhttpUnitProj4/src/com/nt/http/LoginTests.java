package com.nt.http;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LoginTests {

	public static WebConversation conservation = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conservation = new WebConversation();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		conservation = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWithValidCredentials() {

		WebResponse response = null;
		WebForm form = null;
		String result = null;

		try {
			// send request and get the form page

			response = conservation.getResponse("http://localhost:3030/JhttpUnitProj4/index.html");

			form = response.getForms()[0];

			// set values to the form page text boxes

			form.setParameter("uname", "raja");
			form.setParameter("pwd", "rani");
			// submit the form and get the form result
			response = form.submit();
			// get the result content form as the response
			result = response.getText();
			assertEquals("result1", "Valid Credentials", result.trim());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testWithInvalidCredentials() {
		
		WebResponse response=null;
		WebForm form=null;
		String result=null;
		
		try {
			//send the request and get the form
			response=conservation.getResponse("http://localhost:3030/JhttpUnitProj4/index.html");
			//set the values to the text parameters
			form.setParameter("uname", "raja");
			form.setParameter("pwd","rani1");
			
			//submit the form and get the form result
			response=form.submit();
			//get the response in the text format
			result=response.getText();
			
			assertEquals("result2", "Invalid Credentials",result.trim());
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void textWithZeroCredendtials() {
		WebResponse response=null;
		WebForm form=null;
		String result=null;
		try {
			//send the request and get the form
			response=conservation.getResponse("http://localhost:3030/JhttpUnitProj4/index.html");
			//set the values to the text parameters
			form.setParameter("uname", "");
			form.setParameter("pwd", "");
			//submit the form page and get the response
			response=form.submit();
			//get the response in the form of text
			result=response.getText();
			
			assertEquals("result3", "Provide Credentials", result.trim());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
