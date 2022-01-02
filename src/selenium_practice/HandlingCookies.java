package selenium_practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Capturing all cookies
		Set<Cookie> cookies= driver.manage().getCookies();
		System.out.println("Size of cookies:"+cookies.size());
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		// Creating a cookie and adding to the web site
		Cookie cookieObj = new Cookie("MyCookie1234","1234567");
		driver.manage().addCookie(cookieObj);
		cookies= driver.manage().getCookies();
		System.out.println("Size of cookies:"+cookies.size());
		
		// Delete cookies with object reference or cookie name
		//driver.manage().deleteCookie(cookieObj);
		driver.manage().deleteCookieNamed("MyCookie1234");
		cookies= driver.manage().getCookies();
		System.out.println("Size of cookies:"+cookies.size());
		
		// Deleting all cookies
		driver.manage().deleteAllCookies();
		cookies= driver.manage().getCookies();
		System.out.println("Size of cookies:"+cookies.size());

	}

}
