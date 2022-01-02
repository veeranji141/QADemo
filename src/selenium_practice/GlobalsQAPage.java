package selenium_practice;

import java.awt.Choice;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalsQAPage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*driver.findElement(By.xpath("//p/select")).click();
		List<WebElement> options = driver.findElements(By.xpath("//p/select/option"));
		for(WebElement option:options) {
					
			if(option.getAttribute("value").equalsIgnoreCase("IND")) {
				option.click();
				break;
			}
		} */
		
		driver.findElement(By.linkText("Select Elements")).click();
		System.out.println(driver.getTitle()); 
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links present on the webpage: "+links.size());
		try {
		for(WebElement link:links) {
			String linkName = link.getText();
			String linkValue = link.getAttribute("href");
			
			System.out.println("Name of the link: "+linkName);
			
			System.out.println("Value of the link: "+linkValue);
		}
		}
		catch(Exception e) {
			
		}

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		List<WebElement> choices = driver.findElements(By.xpath("//ol[@class='ui-selectable']/li"));
		Actions act =new Actions(driver);
		for(WebElement choice:choices) {
			String choiceName = choice.getText();
			System.out.println();
			if(choiceName.equalsIgnoreCase("Item 2") || choiceName.equalsIgnoreCase("Item 3")) 
					{
				//choice.sendKeys(Keys.DOWN, Keys.RETURN);
			}
		}
	}

}
