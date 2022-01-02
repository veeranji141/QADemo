package selenium_practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotsExample {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Capturing the full screen of full screen
		Calendar c = Calendar.getInstance();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./screenshots/homepage.png");
		FileUtils.copyFile(src, target);
		//driver.close();
		
		// Capturing specific part of the page
		WebElement section = driver.findElement(By.xpath("//div[@class='container-fluid']"));
		File src1 = section.getScreenshotAs(OutputType.FILE);
		File trg1 = new File("./screenshots/"+c.getTime().toString().replace(":"," ").replace(" ", "")+".jpg");
		FileUtils.copyFile(src1, trg1);
		
		// Capturing specific element on the page
		WebElement ele = driver.findElement(By.linkText("JOIN NOW"));
		File src2 = ele.getScreenshotAs(OutputType.FILE);
		File trg2 = new File("./screenshots/element.png");
		FileUtils.copyFile(src2, trg2);
		
		
		

	}

}
