package selenium_practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	// Draw Border
	public static void drawBoarder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element);
	}
	
	// Get title of the page
	
	public static String getTitleByJS(WebDriver driver) {
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	// Click on Web Element
	public static void clickElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	// Generating Alert messages
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
		
	}
	
	// Refreshing page 
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");	
	}

	// Scroll Page Down
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	// Scroll Page Up
	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		}
	
	// Zoom out
	public static void zoomOutByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'");
	}
	
	// Zoom in
		public static void zoomInByJS(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.body.style.zoom='150%'");
		}
	// Flash
		
		public static void flash(WebElement element, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String bgColor =element.getCssValue("backgroundColor");
			for(int i=0; i<50; i++) {
				changeColor("#000000",element,driver);
				changeColor(bgColor, element, driver);
				
			}
			
		}
		public static void changeColor(String color, WebElement element, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		}
}