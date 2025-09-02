package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Utility class for common WebDriver actions and reusable page elements.
 * Provides methods for assertions, navigation, dropdown selection, and screenshot capture.
 * <p>
 * Designed to be extended by page objects for code reuse.
 */
public class WebDriverUtils {

	/** WebDriver instance for interacting with the browser. */
	public WebDriver driver;

	/**
	 * Constructor initializes WebDriver and page elements.
	 * @param driver WebDriver instance
	 */
	public WebDriverUtils(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Navigation and menu elements
	@FindBy(className = "btn-default")
	WebElement goToHome;

	@FindBy(id = "menu-toggle")
	WebElement burgerMenu;

	@FindBy(xpath = "//a[text()= 'History']")
	WebElement historyBtn;
	
	@FindBy(xpath = "//a[text()='Profile']")
	WebElement profileBtn;
	
	@FindBy(xpath = "//a[text() = 'Logout']")
	WebElement burgerLogoutBtn;
	
	@FindBy(xpath = "//p[@class = 'lead'][2]/a")
	WebElement profileLogoutBtn;

	/**
	 * Asserts that two values are equal.
	 * @param value1 First value
	 * @param value2 Second value
	 */
	public void assertEquals(Object value1, Object value2) {

		Assert.assertEquals(value1, value2);
	}

	/**
	 * Gets the text of the first selected option in a dropdown element.
	 * @param selectElement The dropdown WebElement
	 * @return The text of the selected option
	 */
	public String getFirstSelected(WebElement selectElement) {

		Select facilityOptions = new Select(selectElement);
		String option = facilityOptions.getFirstSelectedOption().getText();
		return option;

	}
	
	/** Clicks the 'Go to Home' button. */
	public void goToHome() {
		
		goToHome.click();
	}

	/** Clicks the burger menu icon. */
	public void clickOnBurger() {

		burgerMenu.click();
	}

	/** Clicks the 'History' button in the menu. */
	public void clickOnHistory() {

		historyBtn.click();
	}
	
	/** Clicks the 'Profile' button in the menu. */
	public void clickOnProfile() {
		
		profileBtn.click();
	}

	/** Clicks the 'Logout' button in the burger menu. */
	public void clickOnLogoutOnBurgerMenu() {
		// TODO Auto-generated method stub
		
		burgerLogoutBtn.click();
		
	}
	
	/** Clicks the 'Logout' button in the profile section. */
	public void clickOnLogoutOnProfile() {
		// TODO Auto-generated method stub
		
		profileLogoutBtn.click();
		
	}
	
	/**
	 * Captures a screenshot and saves it to the reports folder.
	 * @param testCaseName Name of the test case (used for filename)
	 * @param driver WebDriver instance
	 * @return Path to the saved screenshot
	 * @throws IOException if file writing fails
	 */
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