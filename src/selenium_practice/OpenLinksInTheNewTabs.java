package selenium_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinksInTheNewTabs {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int numberOfFrames=driver.findElements(By.tagName("iframe")).size();
		System.out.println(numberOfFrames);
		driver.switchTo().frame("courses-iframe");
		
		// open a link in a tab
		//driver.findElement(By.xpath("//a[contains(text(),'REST API')]")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
		
		// open links in multiple tabs
		int numberOfLinksPresent = driver.findElements(By.tagName("a")).size();
		System.out.println("Number Of Links are Present on the webpage:"+numberOfLinksPresent);
		for(int i=0; i<=numberOfLinksPresent; i++) {
			driver.findElement(By.tagName("a")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
					
		}
		System.out.println("Number of tabs are opened:"+driver.getWindowHandles().size());
		Thread.sleep(45);
		driver.quit();
	}

}
