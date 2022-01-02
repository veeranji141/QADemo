package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableHandle {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// How many rows in the table
		int rows = driver.findElements(By.xpath("//table[@name='courses']//tr")).size();
		System.out.println("Number of rows are present in the tabel:"+rows);
		
		// How many columns in the table
		int columns = driver.findElements(By.xpath("//table[@name='courses']//tr/th")).size();
		System.out.println("Number of columns are present in the tabel:"+columns);

		// Retrieve the specific data from the table
		/*String cell = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[2]/td[3]")).getText();
		System.out.print("The data from the cell:" +cell); */
		
		// Retrieve all data from the table
		
		/*for(int r=2; r<=rows; r++) {
			
			for(int c=1; c<=columns; c++) {
				
				String cell1 = driver.findElement(By.xpath("//table[@name='courses']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(cell1+"        ");
			}
			System.out.println();
		} */
		
		// Retrieve the data on specific condition
		
		for(int row=2; row<=rows; row++) {
			String priceText = driver.findElement(By.xpath("//table[@name='courses']//tr["+row+"]/td[3]")).getText();
			int priceValue = Integer.parseInt(priceText);
			if(priceValue>=25) {
				String courseName = driver.findElement(By.xpath("//table[@name='courses']//tr["+row+"]/td[2]")).getText();
				String price = driver.findElement(By.xpath("//table[@name='courses']//tr["+row+"]/td[3]")).getText();
				System.out.println(courseName+"  "+price);
			}
		}
	}

}
