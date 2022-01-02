package selenium_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_WithOutDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement startingPoint = driver.findElement(By.cssSelector("#src"));
		startingPoint.sendKeys("Ban");
		Thread.sleep(4000);
		List<WebElement> from = driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']//li"));
		for(WebElement fr:from) {
			if(fr.getText().equals("Marathahalli, Bangalore")) {
				fr.click();
				break;
			}
		}
		
		WebElement destinationPoint = driver.findElement(By.cssSelector("#dest"));
		destinationPoint.sendKeys("Hyd");
		Thread.sleep(4000);
		List<WebElement> To = driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']//li"));
		for(WebElement to:To) {
			if(to.getText().equals("Chanda Nagar, Hyderabad")) {
				to.click();
				break;
			}
		}
		String endPointName = startingPoint.getText();
		System.out.println(endPointName);
		
		String year = "2021";
		String month = "Dec";
		String date = "31";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		while(true) {
		String mntyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		String arr[] =mntyear.split(" ");
		
		String mth = arr[0];
		String yr = arr[1];
		
		if(mth.equalsIgnoreCase(month) && yr.equals(year)) 
			break;
		
		else 
			driver.findElement(By.xpath("//td[@class='next']")).click();
		}
		
		List<WebElement> allDates =driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr/td"));
		
		for(WebElement dt:allDates) {
			
			String dateValue = dt.getText();
			if(dateValue.equals(date)) {
				dt.click();
				break;
			}
			
		}
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();	
	}

}
