package com.dennismamyala.automation.My_First_Project.Base;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.WebDriverUtils;


public class BaseTest {
    
	protected WebDriverUtils utils;
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
		Utils();
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
	
	public void Utils() {
		
		utils = new WebDriverUtils(driver);
		//return utils;
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		// readFileToString --> Json file content past would get converted string
		// We past this because there a deprecation error on readFileToString method. So
		// it was basically crossed
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// Converting the string to hashmap and we need to get a dependency called
		// ********************** jackson data bind FROM maven repository ******************

		ObjectMapper mapper = new ObjectMapper();

		// From ObjectMapper class there is a readValue method which we use to read a
		// string and then covert it to a hashmap
		// This readValue method expects two arguments, the first argument is the string
		// to be converted, the second argument is responsible for how the string should
		// be converted
		// So the second argument basically says create two hashmaps and then put them
		// inside a list
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}
	
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException{
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    String destPath = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	    File file = new File(destPath);

	    // Create reports folder if it doesn't exist
	    file.getParentFile().mkdirs();

	    FileUtils.copyFile(source, file);

	    return destPath;
	}

}
