package pajeObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FormPage {
	WebDriver driver;
	WebDriverWait wait;

	public FormPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='name'][@name='name']")
	WebElement nameElement;

	@FindBy(xpath = "//input[@id='organizationName'][@name='organizationName']")
	WebElement organizationNameElement;

	@FindBy(xpath = "//input[@id='contactNumber'][@name='contactNumber']")
	WebElement contactElement;

	@FindBy(xpath = "//input[@id='officialEmailId']")
	WebElement officialEmailIdElement;

	@FindBy(xpath = "//select[@id='organizationSize']")
	WebElement organizationSizElement;

	@FindBy(xpath = "//select[@id='interestedIn']")
	WebElement intrestedInElement;

	@FindBy(xpath = "//header[@id='header']//button[contains(@type,'submit')][normalize-space()='Schedule a demo']")
	WebElement scheduleElement;

	public Boolean formtester(String type, String name, String organizationName, String mobile, String email,
			String organizationSize, String intrest) {
		Mydriver.screenShot("Form page");
		Boolean statusBoolean = null;
		if (type.equalsIgnoreCase("positive")) {
			nameElement.sendKeys(name);
			organizationNameElement.sendKeys(organizationName);
			contactElement.sendKeys(mobile);
			officialEmailIdElement.sendKeys(email);

			Select organizationsizeselect = new Select(organizationSizElement);
			organizationsizeselect.selectByValue(organizationSize);
			Select intrestedSelect = new Select(intrestedInElement);
			intrestedSelect.selectByValue(intrest);

			statusBoolean = scheduleElement.isEnabled();

			// Assert.assertEquals(statusBoolean, true);
			// driver.navigate().to("https://www.practo.com/plus/corporate");
			String urlString = driver.getCurrentUrl();
			driver.navigate().to(urlString);
			

		} else if (type.equalsIgnoreCase("negative")) {
			nameElement.sendKeys(name);
			organizationNameElement.sendKeys(organizationName);
			contactElement.sendKeys(mobile);
			officialEmailIdElement.sendKeys(email);
			Select organizationsizeselect = new Select(organizationSizElement);
			organizationsizeselect.selectByValue(organizationSize);
			
			Select intrestedSelect = new Select(intrestedInElement);
			intrestedSelect.selectByValue(intrest);
			
			statusBoolean = scheduleElement.isEnabled();
			String urlString = driver.getCurrentUrl();
			driver.navigate().to(urlString);
			

		}
		return statusBoolean;

	}
	
	public void testClose() {
		driver.quit();
	}
}
