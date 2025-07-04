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

public class WebDriverUtils {

	public WebDriver driver;

	public WebDriverUtils(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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

	public void assertEquals(Object value1, Object value2) {

		Assert.assertEquals(value1, value2);
	}

	public String getFirstSelected(WebElement selectElement) {

		Select facilityOptions = new Select(selectElement);
		String option = facilityOptions.getFirstSelectedOption().getText();
		return option;

	}
	
	public void goToHome() {
		
		goToHome.click();
	}

	// burger
	public void clickOnBurger() {

		burgerMenu.click();
	}

	public void clickOnHistory() {

		historyBtn.click();
	}
	
	public void clickOnProfile() {
		
		profileBtn.click();
	}

	public void clickOnLogoutOnBurgerMenu() {
		// TODO Auto-generated method stub
		
		burgerLogoutBtn.click();
		
	}
	
	public void clickOnLogoutOnProfile() {
		// TODO Auto-generated method stub
		
		profileLogoutBtn.click();
		
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
