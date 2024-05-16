package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pajeObjectModel.FindAndBook;
import pajeObjectModel.Mydriver;

public class FindAndBookTest {
	WebDriverWait wait;
	FindAndBook findAndBookObject;
	
	@Test(priority = 3)
	@Parameters({"city"})
	void popularPlace(String city) throws InterruptedException {
		findAndBookObject=new FindAndBook(Mydriver.getDriver());
		findAndBookObject.extractingLocation(city);
	}
	
	@Test(priority = 4)
	void speciality() {
		findAndBookObject.findingDoctor();
	}


}
