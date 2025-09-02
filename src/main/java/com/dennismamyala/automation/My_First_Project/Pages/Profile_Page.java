package com.dennismamyala.automation.My_First_Project.Pages;

import org.openqa.selenium.WebDriver;

import Utils.WebDriverUtils;

public class Profile_Page extends WebDriverUtils {
	

	public Profile_Page(WebDriver driver) {
		
		super(driver);
		
	}
	
	public void viewProfile () {
		
		clickOnBurger();
		clickOnProfile();
	}
	

}
