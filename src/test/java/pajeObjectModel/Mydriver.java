package pajeObjectModel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Mydriver {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver getDriver(String browser1) {

		if (browser1.equalsIgnoreCase("chrome")) {
			if (driver == null) {
				driver = new ChromeDriver(); // or any other driver
				driver.manage().window().maximize();
				driver.get("https://www.practo.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
		}
		
		if (browser1.equalsIgnoreCase("edge")) {
			if (driver == null) {
				driver = new EdgeDriver(); // or any other driver
				driver.manage().window().maximize();
				driver.get("https://www.practo.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
	}
		return driver;
}

	
	public static void clearDriver() {
		driver=null;
	}
	
	public static void screenShot(String name){
		TakesScreenshot ts=(TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String imgName=name+timeStamp+".png";
		File systemFile=ts.getScreenshotAs(OutputType.FILE);
		File myFile=new File(System.getProperty("user.dir")+ "/ScreenShots/"+ imgName);
		try {
		FileUtils.copyFile(systemFile, myFile);
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
