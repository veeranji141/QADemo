package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouseoperations {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://demoqa.com/buttons"); // double and righr clicks
		
		//driver.get("https://www.globalsqa.com/demo-site/draganddrop/"); // drag and drop
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");   //mouse operation
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*
		WebElement ele1 = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
"
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		Actions act = new Actions(driver);
		
		// To Double Click
		act.doubleClick(ele1).perform();
		
		// To Right click
		act.contextClick(ele2).perform();
		
		// Drag and Drop operation
		
		WebElement source = driver.findElement(By.xpath("//li[1]"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		act.dragAndDrop(source, target).perform(); */
		
		// Mouse Operations
		
		WebElement mouseHover = driver.findElement(By.cssSelector("#mousehover"));
		WebElement top = driver.findElement(By.xpath("//a[text()='Top']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).moveToElement(top).click().perform();
	}

}
