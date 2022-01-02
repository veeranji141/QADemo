package selenium_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertsHandling {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Normal pop-up
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		driver.switchTo().alert().accept();
	
		
		// On button click, alert will appear after 5 seconds
		driver.findElement(By.cssSelector("#timerAlertButton")).click();
		Thread.sleep(5000);
		Alert timerAlertPop = driver.switchTo().alert();
		timerAlertPop.accept();
		
		// On button click, confirm box will appear
		driver.findElement(By.cssSelector("#confirmButton")).click();
		Alert alertConfirmWindow = driver.switchTo().alert();
		//alertWindow.accept();
		alertConfirmWindow.dismiss();

		// On button click, prompt box will appear with text and text box
		driver.findElement(By.cssSelector("#promtButton")).click();
		Alert alertPromptWindow = driver.switchTo().alert();
		System.out.println("The message displayed on alert is:"+alertPromptWindow.getText());
		alertPromptWindow.sendKeys("Veeranjaneyulu Thota");
		alertPromptWindow.accept();
	}

}
