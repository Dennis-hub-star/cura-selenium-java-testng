package com.dennismamyala.automation.My_First_Project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WebDriverUtils;



public class History_Page extends WebDriverUtils{
	
	WebDriver driver;
	
	
	public History_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(className = "panel-heading")
	WebElement actualDate;
	
	@FindBy(id = "facility")
	WebElement actualFacility;
	
	@FindBy(id = "program")
	WebElement actualHealthProgram;
	
	@FindBy(id = "comment")
	WebElement actualComment;
	
	
	
	
	
	public Profile_Page viewHistory(String expectedFacility, String expectedHealthProgram, String expectedDate, String expectedComment) {
		
		clickOnBurger();
		clickOnHistory();
		
		assertEquals(actualFacility.getText(), expectedFacility);
		assertEquals(actualHealthProgram.getText(), expectedHealthProgram);
		assertEquals(actualDate.getText(), expectedDate);
		assertEquals(actualComment.getText(), expectedComment);
		
		goToHome();
		
		
		Profile_Page profile = new Profile_Page(driver);
		
		return profile;
		
		
		
		
	}

}
