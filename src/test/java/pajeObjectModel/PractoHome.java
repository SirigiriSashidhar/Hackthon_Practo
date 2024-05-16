package pajeObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PractoHome {
	WebDriver driver;

	public PractoHome(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Find Doctors']")
	WebElement findDoctElement;
	
	public void clickOnFindDoctor() {
		Mydriver.screenShot("Homepage");
		findDoctElement.click();
		
	}
	
//	public WebDriver driver_update() {
//		return driver;
//	}
//	
	

}
