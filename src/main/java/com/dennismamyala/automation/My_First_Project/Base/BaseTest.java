package com.dennismamyala.automation.My_First_Project.Base;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dennismamyala.automation.My_First_Project.Pages.AppointmentForm_Page;
import com.dennismamyala.automation.My_First_Project.Pages.Landing_Page;
import com.dennismamyala.automation.My_First_Project.Pages.Login_Page;


public class BaseTest {

	Login_Page login_page;
	public WebDriver driver;

	public WebDriver Initializer() {


		String browser = "edge";

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Automation_Testing_Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			
			
			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<>();
			
			
			 prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		        options.setExperimentalOption("prefs", prefs);

		        // Disable other Chrome UI popups
		        options.addArguments("--disable-notifications");
		        options.addArguments("--disable-popup-blocking");
		        options.addArguments("--disable-save-password-bubble");

		        // Force Chrome to use a fresh profile with no saved passwords
		        options.addArguments("user-data-dir=/tmp/selenium-profile-" + UUID.randomUUID());

		
			
			
			driver = new ChromeDriver(options);
			
			

			
		}

		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Automation_Testing_Drivers\\geckodriver-v0.36.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		if (browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\Automation_Testing_Drivers\\edgedriver_win64\\msedgedriver.exe");

			driver = new EdgeDriver();
		}

		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void LaunchApplication() {
		driver = Initializer();
		Landing_Page landingPage = new Landing_Page(driver);
		landingPage.GoTo();
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void Close() {
		
		driver.close();
		
	}
	
	
	public AppointmentForm_Page Signin(String username, String password) {
		
		login_page = new Login_Page(driver);
		AppointmentForm_Page makeAppointment = login_page.Login(username, password);
		return makeAppointment;
		
	}
	
	public void hasErrorMessageAppeared(String message) {
		
		login_page.hasErrorAppeared(message);
	}

}
