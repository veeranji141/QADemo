package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable_Handle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement userName = driver.findElement(By.cssSelector("#input-username"));
		userName.sendKeys("demo");
		
		WebElement pswrd = driver.findElement(By.cssSelector("#input-password"));
		pswrd.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.xpath("//li[@id='menu-sale']")).click();
		
		driver.findElement(By.linkText("Orders")).click();
		
		// Find number of pages in table
		
		String text =driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 20 of 10879 (544 Pages)')]")).getText();
		
		System.out.println("Number of pages:"+text);
		
		// Splitting the string and getting the pages number
		String text1=text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1);
		
		// Converting the string to integer
		int totalPages = Integer.valueOf(text1);
		System.out.println("Total Pages:"+totalPages);

		for(int p=0; p<=3; p++) {
			
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			active_page.click();
			
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
			System.out.println("Number of rows in the table:"+rows);
			
			for(int r=1; r<=rows; r++) {
				//driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[5]")).getText(); // 4 means up to amount column
				
				String orderId = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[2]")).getText();
				String custmerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[3]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[4]")).getText();
				String totalAmount = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[5]")).getText();
				//System.out.println(totalAmount);
				String[] parts =totalAmount.split("[.]");
				String part1=parts[0];
				//System.out.println(part1);
				
				String text2 =part1.substring(part1.indexOf("$")+1);
				text2=text2.replace(",", "");
				int amountValue = Integer.valueOf(text2);  // Converting to integer value
				if(amountValue>=150) {
					System.out.println(orderId+"   "+custmerName+"   "+totalAmount+"   "+status);
				} 
			
			// Converting page number to string to pass the page number in x-path to navigate to the next page
			String pageNo =Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageNo+"']")).click();
		
	}

}
}
}