package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebDriverUtils {

	WebDriver driver;

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

}
