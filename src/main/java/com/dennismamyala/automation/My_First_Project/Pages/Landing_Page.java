package com.dennismamyala.automation.My_First_Project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page {
	
	public WebDriver driver;
	
	public Landing_Page(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "btn-make-appointment")
	WebElement makeAppointmentBtn;

	public void GoTo() {

		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		makeAppointmentBtn.click();
		

		
		
	}
	
	
}
