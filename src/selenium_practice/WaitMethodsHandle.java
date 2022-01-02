package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitMethodsHandle {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// implicitly wait method
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		By eleLocator = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3");
		//waitForElementPresent(driver, eleLocator, 10).click(); // explicitly wait method
		
		waitForElementWithFluentWait(driver, eleLocator).click(); // fluent wait method

	}
// Explicitly wait generic method
	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		myWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
		
	}
	
	// Fluent wait generic method
	
	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(5))
			.ignoring(NoSuchElementException.class);
	
	WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver diver) {
			return driver.findElement(locator);
		}
	});
	
	return element;
}
}