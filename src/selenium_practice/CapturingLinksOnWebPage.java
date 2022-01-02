package selenium_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingLinksOnWebPage {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Click on link using link text
		//driver.findElement(By.linkText("Electronics")).click();
		
		// Click on link using partial link text
		//driver.findElement(By.partialLinkText("Electron")).click();
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("Number of links are present on the Web Page:"+links.size());

		// How to capture all links in the console using for loop
		/* for(int i=0; i<links.size(); i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		} */
		
		// How to capture all links in the console using for each loop
		for(WebElement link:links) {
			System.out.println(link.getText());
			System.out.print(link.getAttribute("href"));
		}
	}

}
