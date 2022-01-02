package selenium_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_WithDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		
		WebElement monthPicker = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthSel = new Select(monthPicker);
		monthSel.selectByVisibleText("Feb");
		
		WebElement yearPicker = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearSel = new Select(yearPicker);
		yearSel.selectByVisibleText("1992");
		
		String dateValue="15";
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		
		for(WebElement date:allDates) {
			if(date.getText().equals(dateValue)) {
				date.click();
				break;
			}
		}
		
		
		

	}

}
