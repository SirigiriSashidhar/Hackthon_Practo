package test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pajeObjectModel.Mydriver;
import pajeObjectModel.ResultPage;

public class ResultPageTest {
	ResultPage resultPageObject;
	@Test(priority = 5)
	void genderFilter() {		
		resultPageObject=new ResultPage(Mydriver.getDriver());
		resultPageObject.noOfDoctorPrint();
		resultPageObject.clickOnmale();
		
	}
	
	@Test(priority = 6)
	void patientStoriesFilter() {
		resultPageObject.clickonpatientstories();
	}
	
	@Test(priority = 7)
	void experienceFilter() {
		resultPageObject.clickonexp();
	}
	
	@Test(priority = 8)
	void allFilters() {		
		resultPageObject.clickOnAllFilter();
	}
	
	@Test(priority = 9)
	void shortByFilter() {
		resultPageObject.clickOnSortBy();
	}
	
	@Test(priority = 11)
	void doctorDetails() {
		resultPageObject.doctorDetails();
	}
	
	@Test(priority = 12)
	void navigatingToCorporate() {
		resultPageObject.corporatePageNavigator();
	}
	
	
}
