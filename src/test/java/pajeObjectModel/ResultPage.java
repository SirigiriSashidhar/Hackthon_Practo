package pajeObjectModel;

import java.time.Duration;
import java.util.List;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {
	WebDriver driver;
	WebDriverWait wait;
	String currentUrl;

	public ResultPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-qa-id=\"doctor_gender_section\"]")
	WebElement genderFilterBoxElement;

	@FindBy(xpath = "//li[@data-qa-id=\"male\"]")
	WebElement maleDoctorElement;

	@FindBy(xpath = "//*[@data-qa-id=\"doctor_review_count_selected\"]")
	WebElement patientStoriesBoxElement;

	@FindBy(xpath = "//li[@aria-label='40+ Patient Stories']")
	WebElement fortypluspatientStoriesElement;

	@FindBy(xpath = "//li[@aria-label='20+ Patient Stories']")
	WebElement twentypluspatientStoriesElement;

	@FindBy(xpath = "//div[@data-qa-id=\"years_of_experience_section\"]")
	WebElement experiencBoxElement;

	@FindBy(xpath = "//li[@aria-label='10+ Years of experience']")
	WebElement tenYearExperienceElement;

	@FindBy(xpath = "//div[@class='u-d-inlineblock u-color--white u-c-pointer']")
	WebElement allFilterBoxElement;

	@FindBy(xpath = "//label[@for='Availability3']")
	WebElement availabiltyElement;
	
	@FindBy(xpath = "//span[@class='c-sort-dropdown__selected c-dropdown__selected']")
	WebElement shortByBoxElement;
	
	@FindBy(xpath = "//span[normalize-space()='Experience - High to Low']")
	WebElement highExperiencElement;
	
	@FindBy(xpath = "//div/h2[@data-qa-id=\"doctor_name\"]")
	List<WebElement> doctorNamElement;
	
	@FindBy(xpath = "//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']")
	WebElement forCorporateWebElement;

	@FindBy(xpath = "//a[normalize-space()='Health & Wellness Plans']")
	WebElement healtyAndWellnessElement;
	
	@FindBy(xpath = "//h1[@class=\"u-xx-large-font u-bold\"]")
	WebElement noOfDoctorElement;
	
	
	public void waitForUrlChange(WebDriver driver) {
		currentUrl = driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return !driver.getCurrentUrl().equals(currentUrl);
			}
		});
	}

	public void clickOnmale() {
		Mydriver.screenShot("Initial Result");
		genderFilterBoxElement.click();
		maleDoctorElement.click();
		waitForUrlChange(driver);
	}

	public void clickonpatientstories() {
		patientStoriesBoxElement.click();
		fortypluspatientStoriesElement.click();
		waitForUrlChange(driver);
	}

	public void clickonexp() {
		experiencBoxElement.click();
		tenYearExperienceElement.click();
		waitForUrlChange(driver);

	}

	public void clickOnAllFilter() {

		allFilterBoxElement.click();
		availabiltyElement.click();
		waitForUrlChange(driver);
	}
	
	public void clickOnSortBy() {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		shortByBoxElement.click();
		wait.until(ExpectedConditions.visibilityOf(highExperiencElement));
		highExperiencElement.click();
		
		System.out.println("After Applying Filter total number of doctor");
		
		noOfDoctorPrint();
				
	}
	
	public void doctorDetails() {
		Mydriver.screenShot("After Filter result");
		for (WebElement x : doctorNamElement) {
			System.out.println(x.getText());
		}
	}
	
	public void corporatePageNavigator() {
		
		forCorporateWebElement.click();
		
		healtyAndWellnessElement.click();
	}
	
	public void noOfDoctorPrint() {
		System.out.println(noOfDoctorElement.getText());
	}

}
