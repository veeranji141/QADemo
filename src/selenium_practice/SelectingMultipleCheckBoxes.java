package selenium_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectingMultipleCheckBoxes {

	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Selecting specific check box
		//driver.findElement(By.xpath("//input[@value='checkbox1']")).click();
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Number of check boxes are present:"+checkBoxes.size());
		
		// Select all check boxes using for each loop
		/* for(WebElement checkBox:checkBoxes) {
			checkBox.click();
		} */
		
		// Select all check boxes using for loop
		int numberOfCheckBoxes = checkBoxes.size();
		/* for(int i=0; i<numberOfCheckBoxes; i++) {
			checkBoxes.get(i).click();
		} */
		
		// Selecting last 2 check boxes using for loop
		
		/* for(int i=numberOfCheckBoxes-2; i<numberOfCheckBoxes; i++) {
			checkBoxes.get(i).click();
		} */
		
		// Selecting first 2 check boxes
		for(int i=0; i<2; i++) {
			checkBoxes.get(i).click();
		}
	}

}
