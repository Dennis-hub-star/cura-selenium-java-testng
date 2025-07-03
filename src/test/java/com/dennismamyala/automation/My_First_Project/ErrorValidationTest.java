package com.dennismamyala.automation.My_First_Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dennismamyala.automation.My_First_Project.Base.BaseTest;
import com.dennismamyala.automation.My_First_Project.Pages.AppointmentForm_Page;
import com.dennismamyala.automation.My_First_Project.Retry.RetryTest;

public class ErrorValidationTest extends BaseTest {

	@Test(dataProvider = "getInvalidLoginData", retryAnalyzer = RetryTest.class)
	public void loginErrorValidation(HashMap<String, String> input) throws InterruptedException {

		Signin(input.get("username"), input.get("password"));

		// Thread.sleep(3000);
		hasErrorMessageAppeared(input.get("errorMessage"));
	}

	//@Test(dataProvider = "getInvalidBookingData")
	public void bookingErrorValidation(HashMap<String, String> input) throws InterruptedException {

		AppointmentForm_Page appointmentForm = Signin(input.get("username"), input.get("password"));
		appointmentForm.book(input.get("facility"), input.get("healthcareProgram"), input.get("visitDate"),
				input.get("comment"), input.get("applyForHospitalReadmission"));
		appointmentForm.hasCurrentUrlChanged(input.get("URL"));
	}

	@DataProvider
	public Object[][] getInvalidLoginData() throws IOException {

		// com.dennismamyala.automation.My_First_Project.Base
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\dennismamyala\\automation\\My_First_Project\\data\\errorValidationLoginData.json");

		Object[][] preparedData = new Object[][] { { data.get(0) }, { data.get(1) }, { data.get(2) }, { data.get(3) } };
		return preparedData;
	}

	@DataProvider
	public Object[][] getInvalidBookingData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\dennismamyala\\automation\\My_First_Project\\data\\invalidAppointmentBookingData.json");

		Object[][] preparedData = new Object[][] { { data.get(0) }, { data.get(1) } };
		return preparedData;

	}

}
