package Build1Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverWait wait;
		JavascriptExecutor js;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.practo.com/doctors");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement locationBoxElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@data-input-box-id='omni-searchbox-locality']")));
//		locationBoxElement.click();
//		locationBoxElement.clear();

		//String loactionString = locationBoxElement.getAttribute("value");
		String userString="Bangalore";
		if (userString.equalsIgnoreCase(locationBoxElement.getAttribute("value"))) {
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
			else {
				locationBoxElement.click();
				locationBoxElement.clear();
				locationBoxElement.sendKeys(userString);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa-id='omni-suggestion-right'][text()='CITY']")));
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

//		locationBoxElement.clear();
//		locationBoxElement.sendKeys("Bangalore");
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//div[@class='c-omni-suggestion-item__content__title']")));
//		List<WebElement> popularlocationList = driver
//				.findElements(By.xpath("//div[@class='c-omni-suggestion-item__content__title']"));
//		System.out.println(popularlocationList.size());
//		
//		// System.out.println("Location box element:"+ locationBoxElement);
//		for (WebElement x : popularlocationList) {		
//			System.out.println(x.getText());
//		
//		}
		
	}
}
