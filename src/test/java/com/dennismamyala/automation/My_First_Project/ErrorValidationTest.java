package com.dennismamyala.automation.My_First_Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dennismamyala.automation.My_First_Project.Base.BaseTest;
import com.dennismamyala.automation.My_First_Project.Pages.AppointmentForm_Page;
import com.dennismamyala.automation.My_First_Project.Retry.RetryTest;

/**
 * ErrorValidationTest contains automated tests for validating error scenarios
 * in login and appointment booking functionalities. It uses TestNG for test
 * management and data-driven testing.
 *
 * <p>
 * - loginErrorValidation: Verifies error messages for invalid login attempts.
 * - bookingErrorValidation: Verifies error handling for invalid appointment booking data.
 * <p>
 * Data is provided via JSON files and loaded using data providers.
 *
 * @author Dennis
 */
public class ErrorValidationTest extends BaseTest {

	/**
	 * Test to validate error messages for invalid login attempts.
	 * Uses data from getInvalidLoginData data provider and retries on failure.
	 *
	 * @param input HashMap containing username, password, and expected error message
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	@Test(dataProvider = "getInvalidLoginData", retryAnalyzer = RetryTest.class)
	public void loginErrorValidation(HashMap<String, String> input) throws InterruptedException {

		Signin(input.get("username"), input.get("password"));

		// Thread.sleep(3000);
		hasErrorMessageAppeared(input.get("errorMessage"));
	}

	/**
	 * Test to validate error handling for invalid appointment booking data.
	 * Uses data from getInvalidBookingData data provider.
	 *
	 * @param input HashMap containing booking details and expected URL
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	@Test(dataProvider = "getInvalidBookingData")
	public void bookingErrorValidation(HashMap<String, String> input) throws InterruptedException {

		AppointmentForm_Page appointmentForm = Signin(input.get("username"), input.get("password"));
		appointmentForm.book(input.get("facility"), input.get("healthcareProgram"), input.get("visitDate"),
				input.get("comment"), input.get("applyForHospitalReadmission"));
		appointmentForm.hasCurrentUrlChanged(input.get("URL"));
	}

	/**
	 * Data provider for invalid login test cases.
	 * Loads test data from errorValidationLoginData.json.
	 *
	 * @return Object[][] containing HashMaps of test data
	 * @throws IOException if file reading fails
	 */
	@DataProvider
	public Object[][] getInvalidLoginData() throws IOException {

		// com.dennismamyala.automation.My_First_Project.Base
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\dennismamyala\\automation\\My_First_Project\\data\\errorValidationLoginData.json");

		Object[][] preparedData = new Object[][] { { data.get(0) }, { data.get(1) }, { data.get(2) }, { data.get(3) } };
		return preparedData;
	}

	/**
	 * Data provider for invalid appointment booking test cases.
	 * Loads test data from invalidAppointmentBookingData.json.
	 *
	 * @return Object[][] containing HashMaps of test data
	 * @throws IOException if file reading fails
	 */
	@DataProvider
	public Object[][] getInvalidBookingData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\dennismamyala\\automation\\My_First_Project\\data\\invalidAppointmentBookingData.json");

		Object[][] preparedData = new Object[][] { { data.get(0) }, { data.get(1) } };
		return preparedData;

	}

}