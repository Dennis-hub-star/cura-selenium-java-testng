package com.dennismamyala.automation.My_First_Project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WebDriverUtils;

public class Login_Page extends WebDriverUtils{

	WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//span[@id = 'demo_username_label']//following-sibling::input")
	WebElement username;
	
	@FindBy(xpath = "//span[@id = 'demo_password_label']//following-sibling::input")
	WebElement password;
	
	@FindBy(id = "txt-username")
	WebElement usernameField;
	
	@FindBy(id = "txt-password")
	WebElement passwordField;
	
	@FindBy(id = "btn-login")
	WebElement loginBtn;
	
	@FindBy(className = "text-danger")
	WebElement loginErrorMessage;
	
	public AppointmentForm_Page Login(String username, String password) {
		

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		
		loginBtn.click();
		
		AppointmentForm_Page makeAppointment = new AppointmentForm_Page(driver);
		return makeAppointment;
		
		
		
	}
	
	
	public void hasErrorAppeared(String message) {
		
		assertEquals(loginErrorMessage.getText(), message);
	}
	
	
	
	
}
