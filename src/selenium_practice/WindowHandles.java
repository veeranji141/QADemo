package selenium_practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		
		
		Set<String> windowIDs=driver.getWindowHandles();
		// Using iterator method
		/* Iterator<String> it = windowIDs.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		System.out.println("Parent window ID is:"+parentWindowID);
		System.out.println("Child window ID is:"+childWindowID); */
		
		// using arraylist
		
		List<String> windowIDLists= new ArrayList(windowIDs); // Converting set into list
		String parentWindowID = windowIDLists.get(0);
		String childWindowID = windowIDLists.get(1);
		//System.out.println("Parent window ID is:"+parentWindowID);
		//System.out.println("Child window ID is:"+childWindowID); 
		
		// Switching to child window
		String childTitle = driver.switchTo().window(childWindowID).getTitle();
		System.out.println(childTitle);
		
		// Performing actions on child class
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("veeranji141@gmail.com");
		Thread.sleep(10000);
		System.out.println("Entered the email id");
		
		// Switch back to parent Window
		String parentTitle = driver.switchTo().window(parentWindowID).getTitle();
		System.out.println(parentTitle);
		/* moving to parent window to child windows
		for(String windoID:windowIDs) {
			String title = driver.switchTo().window(windoID).getTitle();
			System.out.println(title);
			
			// to close the specific browser
			if(title.equals("OrangeHRM HR Software | Free HR Software | HRMS | HRIS")) {
				driver.close();
			}
		} */
		

	}

}
