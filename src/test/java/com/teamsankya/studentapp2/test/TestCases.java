package com.teamsankya.studentapp2.test;

import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.WebTester;


public class TestCases extends TestCase{
	private WebTester tester = new WebTester();
	private static final String BASE_URL="http://localhost:8080/StudentApp2/" ;
	
	@Override
	protected void setUp() throws Exception {
	tester.getTestContext().setBaseUrl(BASE_URL);
	}
	
	@Test
	public void testMethod() throws Exception {
		try {
	tester.beginAt("create.jsp");
	tester.assertFormPresent();
	//insert into table
	tester.setFormElement("regno", "2");
	tester.setFormElement("fname", "prathibha");
	tester.setFormElement("mname", "p");
	tester.setFormElement("lname", "prabhu");
	
	tester.setFormElement("guardian first name", "balakrishna");
	tester.setFormElement("guardian middle name", "padma");
	tester.setFormElement("guardian last name", "ajr");
	
	tester.setFormElement("address1", "puttur");
	tester.setFormElement("address2", "mangalore");
	tester.setFormElement("type", "present");
	tester.setFormElement("city", "mangalore");
	tester.setFormElement("pincode", "45678");
	
	

	tester.submit();
	
	tester.assertTextPresent("student data inserted");
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	}	
}

	
	


