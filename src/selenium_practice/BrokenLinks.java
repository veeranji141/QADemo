package selenium_practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {

		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("http://www.deadlinkcity.com/");
		driver.navigate().to("http://www.deadlinkcity.com/");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		int brokenLinks=0;
		for(WebElement element:links) {
			String url = element.getAttribute("href");
			
			if(url==null || url.isEmpty()) {
				System.out.println(url+"is Empty");
				continue;
			}
			URL link = new URL(url);
			try {
	        HttpURLConnection	httpConnect=(HttpURLConnection)	link.openConnection();
	        httpConnect.connect();
	        
	        if(httpConnect.getResponseCode()>=400) {
	        	
	        	System.out.println(httpConnect.getResponseCode()+url+"is Broken link");
	        	brokenLinks++;
	        }
			else {
				System.out.println(httpConnect.getResponseCode()+url+"is Valid link");
			}
		
		}
			
			catch(Exception e) {
			}
			}
			
		System.out.println("Number of broken links are:"+brokenLinks);
	}

}
