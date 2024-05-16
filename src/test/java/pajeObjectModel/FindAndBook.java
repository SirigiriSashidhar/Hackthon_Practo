package pajeObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAndBook {
	WebDriver driver;
	WebDriverWait wait;

	public FindAndBook(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-input-box-id='omni-searchbox-locality']")
	WebElement locationBoxElement;
	
	@FindBy(xpath = "//div[@class='c-omni-suggestion-item__content__title']")
	WebElement popularLocationDropDownElement;
	
	@FindBy(xpath = "//div[@class='c-omni-suggestion-item__content__title']")
	List<WebElement> popularlocationList;
	
	@FindBy(xpath = "//*[@data-qa-id='omni-suggestion-right'][text()='CITY']")
	WebElement suggestedCityElement;
	
	@FindBy(xpath = "//input[@data-qa-id=\"omni-searchbox-keyword\"]")
	WebElement specialistBoxElement;
	
	@FindBy(xpath = "//div[@data-qa-id=\"omni-suggestion-main\"][contains(normalize-space(), 'Ear-nose-throat (ent) Specialist')]")
	WebElement specialistElement;

	@FindBy(xpath = "//h1[@class=\"u-xx-large-font u-bold\"]")
	WebElement noOfDoctorElement;

	
	public void extractingLocation(String city) {
		String userString = city;
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		if (userString.equalsIgnoreCase("Bangalore")) {
			locationBoxElement.click();
			wait.until(ExpectedConditions.visibilityOf(popularLocationDropDownElement));		
			//System.out.println(popularlocationList.size());
			for (WebElement x : popularlocationList) {
				System.out.println(x.getText());
			}
			Mydriver.screenShot(userString+" Places");
		} else {
			locationBoxElement.click();
			locationBoxElement.clear();
			locationBoxElement.sendKeys(userString);
			wait.until(ExpectedConditions.visibilityOf(suggestedCityElement));
			suggestedCityElement.click();
			locationBoxElement.click();
			wait.until(ExpectedConditions.visibilityOf(popularLocationDropDownElement));	
			Mydriver.screenShot("location");
			//System.out.println(popularlocationList.size());
			for (WebElement x : popularlocationList) {
				System.out.println(x.getText());
			}
			
			Mydriver.screenShot(userString+" Places");
		}

	}

	public void findingDoctor() {
		System.out.println(driver);
		specialistBoxElement.click();
		specialistBoxElement.sendKeys("ENT");		
		wait.until(ExpectedConditions.visibilityOf(specialistElement));
		Mydriver.screenShot("Specialist");
		specialistElement.click();
	}
	


}
