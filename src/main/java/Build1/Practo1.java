package Build1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practo1 {
	WebDriver driver;
	WebDriverWait wait;
	String currentUrl;
	JavascriptExecutor jsExecutor;
	String homePageUrlString = "https://www.practo.com/";

	public void waitForUrlChange(WebDriver driver) {
		currentUrl = driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return !driver.getCurrentUrl().equals(currentUrl);
			}
		});
	}

	@Test(priority = 1)
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.practo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@Test(priority = 2)
	void searchDoctor() {
		WebElement findDoctElement = driver
				.findElement(By.xpath("//div[@class='product-tab__title'][text()='Find Doctors']"));
		findDoctElement.click();
	}

	@Test(priority = 3)
	void popularPlace() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement locationBoxElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@data-input-box-id='omni-searchbox-locality']")));

		String userString = "Bangalore";

		if (userString.equalsIgnoreCase("Bangalore")) {
			locationBoxElement.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='c-omni-suggestion-item__content__title']")));
			List<WebElement> popularlocationList = driver
					.findElements(By.xpath("//div[@class='c-omni-suggestion-item__content__title']"));
			System.out.println(popularlocationList.size());
			for (WebElement x : popularlocationList) {
				System.out.println(x.getText());
			}
		} else {
			locationBoxElement.click();
			locationBoxElement.clear();
			locationBoxElement.sendKeys(userString);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@data-qa-id='omni-suggestion-right'][text()='CITY']")));
			driver.findElement(By.xpath("//*[@data-qa-id='omni-suggestion-right'][text()='CITY']")).click();
			locationBoxElement.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='c-omni-suggestion-item__content__title']")));
			List<WebElement> popularlocationList = driver
					.findElements(By.xpath("//div[@class='c-omni-suggestion-item__content__title']"));
			System.out.println(popularlocationList.size());
			for (WebElement x : popularlocationList) {
				System.out.println(x.getText());
			}

		}
	}

	@Test(priority = 4)
	void speciality() {
		WebElement specialistBoxElement = driver
				.findElement(By.xpath("//input[@data-input-box-id=\"omni-searchbox-keyword\"]"));
		specialistBoxElement.click();
		specialistBoxElement.sendKeys("ENT");
		WebElement specialElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@data-qa-id=\"omni-suggestion-main\"][contains(normalize-space(), 'Ear-nose-throat (ent) Specialist')]")));
		specialElement.click();
		WebElement noOfDoctorElement = driver.findElement(By.xpath("//h1[@class=\"u-xx-large-font u-bold\"]"));
		System.out.println(noOfDoctorElement.getText());
	}

	@Test(priority = 5)
	void genderFilter() throws StaleElementReferenceException {
		WebElement genderFilterBoxElement = driver
				.findElement(By.xpath("//div[@data-qa-id=\"doctor_gender_section\"]"));
		genderFilterBoxElement.click();
		WebElement maleDoctorElement = driver.findElement(By.xpath("//li[@data-qa-id=\"male\"]"));
		WebElement femaleDoctorElement = driver.findElement(By.xpath("//li[@data-qa-id=\"female\"]"));
		maleDoctorElement.click();
		waitForUrlChange(driver);

	}

	@Test(priority = 6)
	void patientStoriesFilter() {

		WebElement patientStoriesBoxElement = driver
				.findElement(By.xpath("//*[@data-qa-id=\"doctor_review_count_selected\"]"));
		patientStoriesBoxElement.click();
		WebElement twentypluspatientStoriesElement = driver
				.findElement(By.xpath("//li[@aria-label='20+ Patient Stories']"));
		WebElement fortypluspatientStoriesElement = driver
				.findElement(By.xpath("//li[@aria-label='40+ Patient Stories']"));
		fortypluspatientStoriesElement.click();

		waitForUrlChange(driver);

	}

	@Test(priority = 7)
	void experienceFilter() {
		WebElement experiencBoxElement = driver
				.findElement(By.xpath("//div[@data-qa-id=\"years_of_experience_section\"]"));
		experiencBoxElement.click();

		WebElement tenYearExperienceElement = driver
				.findElement(By.xpath("//li[@aria-label='10+ Years of experience']"));
		tenYearExperienceElement.click();
		waitForUrlChange(driver);
	}

	@Test(priority = 8)
	void allFilters() {
		WebElement allFilterBoxElement = driver
				.findElement(By.xpath("//div[@class='u-d-inlineblock u-color--white u-c-pointer']"));
		allFilterBoxElement.click();

		WebElement availabiltyElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Availability3']")));
		availabiltyElement.click();
		waitForUrlChange(driver);
	}

	@Test(priority = 9)
	void shortByFilter() {
		WebElement shortByBoxElement = driver
				.findElement(By.xpath("//span[@class='c-sort-dropdown__selected c-dropdown__selected']"));
		shortByBoxElement.click();

		WebElement highExperiencElement = driver
				.findElement(By.xpath("//span[normalize-space()='Experience - High to Low']"));
		highExperiencElement.click();

	}

	@Test(priority = 10)
	void noOfDoctor() {
		WebElement noOfDoctorElement = driver.findElement(By.xpath("//h1[@class=\"u-xx-large-font u-bold\"]"));
		System.out.println(noOfDoctorElement.getText());
	}

	@Test(priority = 11)
	void doctorDetails() {

		jsExecutor = (JavascriptExecutor) driver;
		// jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight);",
		// "");

		jsExecutor.executeScript("window.scrollBy(0,1500);", "");
		List<WebElement> doctorNamElement = driver.findElements(By.xpath("//div/h2[@data-qa-id=\"doctor_name\"]"));
		System.out.println(doctorNamElement.size());

		for (WebElement x : doctorNamElement) {
			System.out.println(x.getText());
		}

	}

	@Test(priority = 12)
	void formValidation() {
		// driver.navigate().to(homePageUrlString);
		// waitForUrlChange(driver);
		WebElement forCorporateWebElement = driver.findElement(By.xpath(
				"//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']"));
		forCorporateWebElement.click();

		WebElement healtyAndWellnessElement = driver
				.findElement(By.xpath("//a[normalize-space()='Health & Wellness Plans']"));
		healtyAndWellnessElement.click();
	}

	@Test(priority = 13, dataProvider = "formData")
	void mytest(String type, String name, String organizationName, String mobile, String email, String organizationSize,
			String intrest) throws InterruptedException {


		if (type.equalsIgnoreCase("positive")) {
			WebElement nameElement = driver.findElement(By.xpath("//input[@id='name'][@name='name']"));
			// nameElement.sendKeys("Subrat");
			nameElement.sendKeys(name);

			WebElement organizationNameElement = driver
					.findElement(By.xpath("//input[@id='organizationName'][@name='organizationName']"));

			// organizationNameElement.sendKeys("NewCognizant");
			organizationNameElement.sendKeys(organizationName);

			WebElement contactElement = driver
					.findElement(By.xpath("//input[@id='contactNumber'][@name='contactNumber']"));
			// contactElement.sendKeys("909090909");
			contactElement.sendKeys(mobile);

			WebElement officialEmailIdElement = driver.findElement(By.xpath("//input[@id='officialEmailId']"));
			// officialEmailIdElement.sendKeys("subrat@xyz.com");
			officialEmailIdElement.sendKeys(email);

			WebElement organizationSizElement = driver.findElement(By.xpath("//select[@id='organizationSize']"));
			Select organizationsizeselect = new Select(organizationSizElement);
			// organizationsizeselect.selectByValue("1001-5000");
			organizationsizeselect.selectByValue(organizationSize);

			WebElement intrestedInElement = driver.findElement(By.xpath("//select[@id='interestedIn']"));
			Select intrestedSelect = new Select(intrestedInElement);
			intrestedSelect.selectByValue(intrest);

			WebElement scheduleElement = driver.findElement(By.xpath(
					"//header[@id='header']//button[contains(@type,'submit')][normalize-space()='Schedule a demo']"));
			Boolean statusBoolean = scheduleElement.isEnabled();

			Assert.assertEquals(statusBoolean, true);
			//driver.navigate().to("https://www.practo.com/plus/corporate");
			String urlString=driver.getCurrentUrl();
			driver.navigate().to(urlString);


		} else if (type.equalsIgnoreCase("negative")) {
			WebElement nameElement = driver.findElement(By.xpath("//input[@id='name'][@name='name']"));
			// nameElement.sendKeys("Subrat");
			nameElement.sendKeys(name);

			WebElement organizationNameElement = driver
					.findElement(By.xpath("//input[@id='organizationName'][@name='organizationName']"));

			// organizationNameElement.sendKeys("NewCognizant");
			organizationNameElement.sendKeys(organizationName);

			WebElement contactElement = driver
					.findElement(By.xpath("//input[@id='contactNumber'][@name='contactNumber']"));
			// contactElement.sendKeys("909090909");
			contactElement.sendKeys(mobile);

			WebElement officialEmailIdElement = driver.findElement(By.xpath("//input[@id='officialEmailId']"));
			// officialEmailIdElement.sendKeys("subrat@xyz.com");
			officialEmailIdElement.sendKeys(email);

			WebElement organizationSizElement = driver.findElement(By.xpath("//select[@id='organizationSize']"));
			Select organizationsizeselect = new Select(organizationSizElement);
			// organizationsizeselect.selectByValue("1001-5000");
			organizationsizeselect.selectByValue(organizationSize);

			WebElement intrestedInElement = driver.findElement(By.xpath("//select[@id='interestedIn']"));
			Select intrestedSelect = new Select(intrestedInElement);
			intrestedSelect.selectByValue(intrest);

			WebElement scheduleElement = driver.findElement(By.xpath(
					"//header[@id='header']//button[contains(@type,'submit')][normalize-space()='Schedule a demo']"));
			Boolean statusBoolean = scheduleElement.isEnabled();

			Assert.assertEquals(statusBoolean, false);
			String urlString=driver.getCurrentUrl();
			driver.navigate().to(urlString);
			

		}
	}

	@DataProvider(name = "formData")
	String[][] formData() {
		String data[][] = {
				
				{ "positive", "Subart", "NewCognizant", "9090904935", "Subrat@xyz.com", "1001-5000",
						"Referring someone" },
				{ "negative", "Subart", "NewCognizant", "90909049", "Subrat@xyz.com", "1001-5000",
				"Referring someone" },
				{ "negative", "Subart", "NewCognizant", "9090904935", "Subrat@xyz", "1001-5000",
				"Referring someone" },
		};

		return data;
	}

}
