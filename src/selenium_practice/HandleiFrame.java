package selenium_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleiFrame {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?help-doc.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int numberOfframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of frames present on the webpage:"+numberOfframes);
		// 1st frame
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();
		
		//2nd frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[contains(text(),'Alert')]")).click();
		
		//3rd frame
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//li[contains(text(),'Help')]")).click();
		// to switch to main frame
		//driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("/html/body/main/ul/li[2]/a")).click();
		System.out.println(driver.getTitle());
	}

}
