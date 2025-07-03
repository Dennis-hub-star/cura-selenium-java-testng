package com.dennismamyala.automation.My_First_Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dennismamyala.automation.My_First_Project.Base.BaseTest;
import com.dennismamyala.automation.My_First_Project.Pages.AppointmentConfirmation_Page;
import com.dennismamyala.automation.My_First_Project.Pages.AppointmentForm_Page;
import com.dennismamyala.automation.My_First_Project.Pages.History_Page;
import com.dennismamyala.automation.My_First_Project.Pages.Profile_Page;

public class BookAppointment extends BaseTest {
	

	
	@Test(dataProvider = "getValidBookingData")
	public void bookAppointmentTest(HashMap<String, String> input) throws InterruptedException {

		AppointmentForm_Page makeAppointment = Signin(input.get("username"), input.get("password"));
		System.out.println("Testing the dummy code");
		
		AppointmentConfirmation_Page confirmation = makeAppointment.book(input.get("facility"), input.get("healthcareProgram"), input.get("visitDate"), input.get("comment"), input.get("applyForHospitalReadmission"));
		
		History_Page history = confirmation.validateConfirmation(input.get("facility"), input.get("healthcareProgram"), input.get("visitDate"), input.get("comment"), input.get("applyForHospitalReadmission"));
		Profile_Page profile = history.viewHistory(input.get("facility"), input.get("healthcareProgram"), input.get("visitDate"), input.get("comment"), input.get("applyForHospitalReadmission"));
		profile.viewProfile();
		
	}
	
	
	
	@Test(dataProvider = "getValidLoginData")
	public void testNavigateToProfileFromAppointmentForm(HashMap<String, String> input) {
		
		
		Signin(input.get("username"), input.get("password"));
		utils.clickOnBurger();
		utils.clickOnProfile();
		
	}
	
	@Test(dataProvider = "getValidLoginData")
	public void testNavigateToProfileFromHistory(HashMap<String, String> input) {
		Signin(input.get("username"), input.get("password"));
		utils.clickOnBurger();
		utils.clickOnHistory();
		utils.clickOnBurger();
		utils.clickOnProfile();
		
	}
	
	@Test(dataProvider = "getValidLoginData")
	public void testNavigateToHistoryFromAppointmentForm(HashMap<String, String> input) {
		Signin(input.get("username"), input.get("password"));
		utils.clickOnBurger();
		utils.clickOnHistory();
		
	}
	
	@Test(dataProvider = "getValidLoginData")
	public void testNavigateToHistoryFromProfile(HashMap<String, String> input) {
		Signin(input.get("username"), input.get("password"));
		utils.clickOnBurger();
		utils.clickOnProfile();
		utils.clickOnBurger();
		utils.clickOnHistory();
		
	}
	
	@Test(dataProvider = "getValidLoginData")
	public void testLogoutFromHomepage(HashMap<String, String> input) {
		Signin(input.get("username"), input.get("password"));
		utils.clickOnBurger();
		utils.clickOnLogoutOnBurgerMenu();	
	}
	
	@Test(dataProvider = "getValidLoginData")
	public void testLogoutFromProfileUsingBurgerMenu(HashMap<String, String> input) {
		Signin(input.get("username"), input.get("password"));
		utils.clickOnBurger();
		utils.clickOnProfile();
		utils.clickOnBurger();
		utils.clickOnLogoutOnBurgerMenu();	
		
		
		
	}
	
	@Test(dataProvider = "getValidLoginData")
	public void testLogoutFromProfileUsingLogoutBtn(HashMap<String, String> input) {
		Signin(input.get("username"), input.get("password"));
		utils.clickOnBurger();
		utils.clickOnProfile();
		utils.clickOnLogoutOnProfile();	
		
		
		
	}
	
	
	@DataProvider
	public Object[] getValidLoginData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\main\\java\\com\\dennismamyala\\automation\\My_First_Project\\data\\validLoginData.json");
		Object[] preparedData = new Object[] {data.get(0)};
		return preparedData;
	}
	
	
	
	@DataProvider
	public Object[][] getValidBookingData() throws IOException {
		
		List <HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\main\\java\\com\\dennismamyala\\automation\\My_First_Project\\data\\appointmentBookingData.json");
		
		Object[][] preparedData = new Object[][] {{data.get(0)}, {data.get(1)}, {data.get(2)}};
		return preparedData;
	}
	

}
