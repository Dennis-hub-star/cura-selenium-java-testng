package com.dennismamyala.automation.My_First_Project.Pages;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WebDriverUtils;

public class AppointmentForm_Page extends WebDriverUtils {

	WebDriver driver;

	public AppointmentForm_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "chk_hospotal_readmission")
	WebElement checkBox;

	@FindBy(id = "txt_visit_date")
	WebElement dateField;

	@FindBy(className = "datepicker-switch")
	WebElement datePicker1;

	@FindBy(xpath = "//div[@class = 'datepicker-months']/ table/ thead/tr[2]/th[2]")
	WebElement datePicker2;

	@FindBy(xpath = "//div[@class = 'datepicker-months']/ table/ thead/tr[2]/th[1]")
	WebElement prevBtn;

	@FindBy(xpath = "//div[@class = 'datepicker-months']/ table/ thead/tr[2]/th[3]")
	WebElement nextBtn;

	@FindBy(id = "txt_comment")
	WebElement commentBox;

	@FindBy(id = "btn-book-appointment")
	WebElement bookAppointmentBtn;

	public AppointmentConfirmation_Page book(String facility, String healthProgram, String date, String comment,
			String applyForHospitalReadmission) throws InterruptedException {
		String actualFaciltiy = facility.equals("") ? "Tokyo" : facility;
		String actualHealthProgram = healthProgram.equals("") ? "Medicare" : healthProgram;
		List<WebElement> options = driver.findElements(By.tagName("option"));

		options.stream().forEach(option -> {
			if (option.getText().contains(actualFaciltiy))
				option.click();
		});

		if (applyForHospitalReadmission.equalsIgnoreCase("Yes")) {
			checkBox.click();
		}

		WebElement radioBtn = driver.findElement(By.xpath("//label[@class = 'radio-inline']/input[@id = 'radio_program_"
				+ actualHealthProgram.toLowerCase() + "']"));

		radioBtn.click();

		if (date != "") {

			dateField.click();
			datePicker1.click();
			String[] splittedDate = date.split("/");
			String pickedDay = splittedDate[0];
			int monthNumber = Integer.parseInt(splittedDate[1]);
			String fullMonthName = Month.of(monthNumber).name().substring(0, 3);
			String year = splittedDate[2];

			while (true) {

				if (datePicker2.getText().contains(year)) {

					List<WebElement> months = driver.findElements(By.className("month"));
					List<WebElement> month = months.stream()
							.filter(mon -> mon.getText().equalsIgnoreCase(fullMonthName)).collect(Collectors.toList());
					month.getFirst().click();

					List<WebElement> days = driver.findElements(By.className("day"));

					Optional<WebElement> day = days.stream()
							.filter(d -> d.getAttribute("class") != "old day" && d.getText().equalsIgnoreCase(pickedDay)

							).findFirst();

					day.get().click();

					break;
				}

				nextBtn.click();

			}

		}

		commentBox.sendKeys(comment);

		
		bookAppointmentBtn.click();


		AppointmentConfirmation_Page appointmentConfirmation = new AppointmentConfirmation_Page(driver);
		return appointmentConfirmation;

	}

	public void hasCurrentUrlChanged(String URL) {

		String originalUrl = driver.getCurrentUrl();
		assertEquals(originalUrl, URL);

	}

}
