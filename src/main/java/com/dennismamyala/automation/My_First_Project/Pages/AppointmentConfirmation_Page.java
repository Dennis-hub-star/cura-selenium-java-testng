package com.dennismamyala.automation.My_First_Project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WebDriverUtils;

/**
 * Page object representing the appointment confirmation page.
 * Provides methods to validate confirmation details and navigate to history.
 */
public class AppointmentConfirmation_Page extends WebDriverUtils {

	WebDriver driver;

	/**
	 * Constructor initializes WebDriver and page elements.
	 * @param driver WebDriver instance
	 */
	public AppointmentConfirmation_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "facility")
	WebElement actualFacility;

	@FindBy(id = "hospital_readmission")
	WebElement hospitalReadmission;

	@FindBy(id = "program")
	WebElement actualHealthProgram;

	@FindBy(id = "visit_date")
	WebElement visitDate;

	@FindBy(id = "comment")
	WebElement ActualComment;

	/**
	 * Validates the appointment confirmation details against expected values.
	 * Navigates to the history page after validation.
	 *
	 * @param expectedFacility Expected facility name
	 * @param expectedHealthProgram Expected health program
	 * @param expectedDate Expected visit date
	 * @param expectedComment Expected comment
	 * @param applyForHospitalReadmission Expected hospital readmission status ("Yes" or "No")
	 * @return History_Page object for further navigation
	 */
	public History_Page validateConfirmation(String expectedFacility, String expectedHealthProgram, String expectedDate, String expectedComment, String applyForHospitalReadmission) {
        
		String isHospitalReadmissionApplied = applyForHospitalReadmission.equalsIgnoreCase("Yes") ? "Yes" : "No";
		assertEquals(actualFacility.getText(), expectedFacility);
		assertEquals(actualHealthProgram.getText().trim(), expectedHealthProgram);
		assertEquals(ActualComment.getText(), expectedComment);
		assertEquals(visitDate.getText(), expectedDate);
		assertEquals(hospitalReadmission.getText(), isHospitalReadmissionApplied);
		goToHome();
		History_Page history = new History_Page(driver);
		return history;
	}

}