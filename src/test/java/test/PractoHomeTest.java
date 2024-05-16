package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pajeObjectModel.Mydriver;
import pajeObjectModel.PractoHome;

public class PractoHomeTest {
	
	WebDriver driver;
	PractoHome practoHomeObject;
	
	
	@Test(priority = 1)
	@Parameters({"browser"})
	void setUp(String browser) {
		driver=Mydriver.getDriver(browser);
		practoHomeObject=new PractoHome(driver);
	}
	
	@Test(priority = 2)
	void searchDoctor() {
		practoHomeObject.clickOnFindDoctor();
		
	}

}
