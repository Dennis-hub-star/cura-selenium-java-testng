package com.dennismamyala.automation.My_First_Project;

import org.testng.annotations.Test;

import com.dennismamyala.automation.My_First_Project.Base.BaseTest;
import com.dennismamyala.automation.My_First_Project.Pages.AppointmentConfirmation_Page;
import com.dennismamyala.automation.My_First_Project.Pages.AppointmentForm_Page;
import com.dennismamyala.automation.My_First_Project.Pages.History_Page;
import com.dennismamyala.automation.My_First_Project.Pages.Profile_Page;

import Utils.WebDriverUtils;

public class BookAppointment extends BaseTest {
	
	//WebDriverUtils utils; 
	
	// Facilities 
	String tokyoFacility = "Tokyo CURA Healthcare Center";
	String hongkongFacility = "Hongkong CURA Healthcare Center";
	String seoulFacilty = "Seoul CURA Healthcare Center";
	
	// Request for re-readmission 
	//String applyForReadmission = "Yes";
	
	// Programs
	String programMedicare = "Medicare";
	String programMedicaid = "Medicaid";
	String noProgram = "None";
	
	// Appointment date
	String date = "12/12/2025";
	
	// Comment
	String comment = "I need medical attention for my live infection";
	
	@Test
	public void bookAppointmentTest() throws InterruptedException {

		AppointmentForm_Page makeAppointment = Signin("John Doe", "ThisIsNotAPassword");
		System.out.println("Testing the dummy code");
		
		AppointmentConfirmation_Page confirmation = makeAppointment.book(tokyoFacility, programMedicaid, date, comment);
		
		History_Page history = confirmation.validateConfirmation(tokyoFacility, programMedicaid, date, comment);
		Profile_Page profile = history.viewHistory(tokyoFacility, programMedicaid, date, comment);
		profile.viewProfile();
		
	}
	
	@Test
	public void testNavigateToProfileFromAppointmentForm() {
		
		
		Signin("John Doe", "ThisIsNotAPassword");
		utils.clickOnBurger();
		utils.clickOnProfile();
		
	}
	
	@Test
	public void testNavigateToProfileFromHistory() {
		Signin("John Doe", "ThisIsNotAPassword");
		utils.clickOnBurger();
		utils.clickOnHistory();
		utils.clickOnBurger();
		utils.clickOnProfile();
		
	}
	
	@Test
	public void testNavigateToHistoryFromAppointmentForm() {
		Signin("John Doe", "ThisIsNotAPassword");
		utils.clickOnBurger();
		utils.clickOnHistory();
		
	}
	
	@Test
	public void testNavigateToHistoryFromProfile() {
		Signin("John Doe", "ThisIsNotAPassword");
		utils.clickOnBurger();
		utils.clickOnProfile();
		utils.clickOnBurger();
		utils.clickOnHistory();
		
	}
	
	@Test
	public void testLogoutFromHomepage() {
		Signin("John Doe", "ThisIsNotAPassword");
		utils.clickOnBurger();
		utils.clickOnLogoutOnBurgerMenu();	
	}
	
	@Test
	public void testLogoutFromProfileUsingBurgerMenu() {
		Signin("John Doe", "ThisIsNotAPassword");
		utils.clickOnBurger();
		utils.clickOnProfile();
		utils.clickOnBurger();
		utils.clickOnLogoutOnBurgerMenu();	
		
		
		
	}
	
	@Test
	public void testLogoutFromProfileUsingLogoutBtn() {
		Signin("John Doe", "ThisIsNotAPassword");
		utils.clickOnBurger();
		utils.clickOnProfile();
		utils.clickOnLogoutOnProfile();	
		
		
		
	}
	
	
	
	
//	@Test(dependsOnMethods = "bookAppointmentTest")
//	public void viewHistoryTest() {
//		
//		
//	}
//	
	

}
