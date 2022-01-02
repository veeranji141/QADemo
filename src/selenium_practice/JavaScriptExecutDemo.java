package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement openWindowBtn = driver.findElement(By.xpath("//button[@id='openwindow']"));
		JavaScriptUtil.drawBoarder(openWindowBtn, driver);
		Thread.sleep(4000);
		JavaScriptUtil.flash(openWindowBtn, driver);
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		JavaScriptUtil.clickElement(checkBox, driver);
		Thread.sleep(4000);
		//JavaScriptUtil.generateAlert(driver, "Generated an alert message using JS");
		
		JavaScriptUtil.refreshBrowserByJS(driver);
		Thread.sleep(4000);
		JavaScriptUtil.scrollPageDown(driver);
		Thread.sleep(4000);
		JavaScriptUtil.scrollPageUp(driver);
		Thread.sleep(4000);
		JavaScriptUtil.zoomOutByJS(driver);
		Thread.sleep(4000);
		JavaScriptUtil.zoomInByJS(driver);
		
		
	}

}
