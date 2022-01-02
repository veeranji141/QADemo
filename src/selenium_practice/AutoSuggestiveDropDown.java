package selenium_practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {
public static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium");
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='eIPGRd']//div[2]//div[1]//span//b"));
		System.out.println("Size of auto suggestives:"+options.size());
		
		for(WebElement option:options) {
			//System.out.println(option.getText());
			if(option.getText().contains("download")) {
				option.click();
				break;
			
			}
		}

	}

}
