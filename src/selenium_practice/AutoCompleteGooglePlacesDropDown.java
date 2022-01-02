package selenium_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteGooglePlacesDropDown {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		searchBox.clear();
		searchBox.sendKeys("Toronto");
		
		String text;
		
		do {
		
		searchBox.sendKeys(Keys.ARROW_DOWN);
		text=searchBox.getAttribute("value");
		
		if(text.equalsIgnoreCase("Toronto, OH, USA")) {
			searchBox.sendKeys(Keys.ENTER);
			break;
		}
		} while(!text.isEmpty());
	}

}
