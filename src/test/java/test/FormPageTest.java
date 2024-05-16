package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pajeObjectModel.FormPage;
import pajeObjectModel.Mydriver;

public class FormPageTest {
	WebDriver driver;
	FormPage formPageObject;
	@BeforeClass
	void settingup() {
		formPageObject=new FormPage(Mydriver.getDriver());
	}
	
	@Test(priority = 13, dataProvider = "formData")
	void formtest(String type, String name, String organizationName, String mobile, String email, String organizationSize,
			String intrest) throws InterruptedException {
		
		Boolean actual=formPageObject.formtester(type, name, organizationName, mobile, email, organizationSize, intrest);
		if(type.equalsIgnoreCase("positive")) {
			Assert.assertEquals(actual, true);
		}else {
			Assert.assertEquals(actual, false);
		}
		
	}
	@DataProvider(name = "formData")
	String[][] formData() {
		String data[][] = {
				
				{ "positive", "sirigiri", "NewCognizant", "9090904935", "sirigiri@xyz.com", "1001-5000",
						"Referring someone" },
				{ "negative", "sirigiri", "NewCognizant", "90909049", "sirigiri@xyz.com", "1001-5000",
				"Referring someone" },
				{ "negative", "sirigiri", "NewCognizant", "9090904935", "sirigiri@xyz", "1001-5000",
				"Referring someone" },
		};

		return data;
	}
	
	@Test(priority = 14)
	void tearDown() {
		Mydriver.clearDriver();
		formPageObject.testClose();
	}
	

}
