package com.dennismamyala.automation.My_First_Project;

import org.testng.annotations.Test;

import com.dennismamyala.automation.My_First_Project.Base.BaseTest;
import com.dennismamyala.automation.My_First_Project.Pages.AppointmentForm_Page;


public class ErrorValidationTest extends BaseTest {
	
	@Test
	public void loginErrorValidation() throws InterruptedException {
		
		Signin("John Doe", "ThisIsNotAPasswor");
		
		//Thread.sleep(3000);
		hasErrorMessageAppeared("Login failed! Please ensure the username and password are valid.");
	}
	
	
	@Test
	public void bookingErrorValidation() throws InterruptedException {
		
		AppointmentForm_Page appointmentForm = Signin("John Doe", "ThisIsNotAPassword");
		appointmentForm.book("", "", "", "");
		appointmentForm.hasCurrentUrlChanged("https://katalon-demo-cura.herokuapp.com/#appointment");
	}

}
