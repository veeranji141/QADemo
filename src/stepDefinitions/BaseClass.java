package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ElementsPage_pageObjects;


public class BaseClass {
	public static WebDriver driver;
	public ElementsPage_pageObjects EP;
	public static Properties prop;
	
	public BaseClass()
	{
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\thotav3\\eclipse-workspace\\QADemo\\src\\utilities\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			
			e.getMessage();
		}
	}
		public static void intialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver =  new ChromeDriver();		
		}
			else if(browserName.equals("ff")){
				WebDriverManager.firefoxdriver().setup();
				driver =  new FirefoxDriver();	
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
		
	
	// Created for generating Random String foe Unique Email ID
	/*public static String randomString() {
		String generatedEmail = RandomStringUtils.randomAlphabetic(5);
		return generatedEmail;
		
	} */
	}
}
