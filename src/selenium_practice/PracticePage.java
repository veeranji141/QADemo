package selenium_practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {

	public static WebDriver driver;
	public void base() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// text element
	public void firstNameField(String fname) {
		WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.clear();
		firstName.getAttribute(fname);
		firstName.sendKeys(fname);
	}
	
	// radio button
	public void selectTRadioBtn() {
		WebElement radioBtn = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		radioBtn.click();
		boolean result = radioBtn.isSelected();
		System.out.println("Radio button is:"+result);
	
	}
	
	public void selectCheckBox() {
		WebElement checkBox = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
		System.out.println(checkBox.isDisplayed());
		System.out.println(checkBox.isEnabled());
		checkBox.click();
		boolean result = checkBox.isSelected();
		System.out.println("check box is selected:"+result);
	}
	
	public void selectStateDropDown() {
		WebElement stateDropDown = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
		stateDropDown.click();
		List<WebElement> states = driver.findElements(By.xpath(""));
		System.out.println("N.o of states present in the dropdown"+states.size());
		selectOptionsFromDropDown(states, "Haryana");
		
		//Select select = new Select(stateDropDown);
		//select.isMultiple();
		//select.selectByIndex(1);
		//select.selectByValue("");
		//select.selectByVisibleText("Haryana");
	}
	
	public void selectCityDropDown() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select City')]"))); 

		WebElement cityDropDown = driver.findElement(By.xpath("//div[contains(text(),'Select City')]"));
		Select select = new Select(cityDropDown);
		select.selectByIndex(1);
	}
	
	public void openNewTab() {
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement tab = driver.findElement(By.cssSelector("#tabButton"));
		tab.click();
		System.out.println(driver.getTitle());		
	}
	
	public void handlingTabs() {
		//int numberOfTabsOpened = driver.getWindowHandles().size();
		ArrayList<String>  tabs = new ArrayList<> (driver.getWindowHandles());
		//System.out.println("Number of windows opened are:"+numberOfTabsOpened);
		driver.switchTo().window(tabs.get(1));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		//driver.switchTo().window(tabs.get(0));
		//System.out.println(driver.getTitle());
		
	}
	
	public void alertsHandling() {
		driver.get("https://demoqa.com/alerts");
		WebElement popUP1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
				popUP1.click();
		System.out.println(driver.switchTo().alert().getText());
	}
	
	public static void selectOptionsFromDropDown(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			option.getText().equalsIgnoreCase(value);
			option.click();
			break;
		}
	}
	
		public static void main(String[] args) throws IOException {
		PracticePage pp = new PracticePage();
		pp.base();
		//pp.firstNameField("Veeranjaneyulu");
		//pp.selectTRadioBtn();
		//pp.selectCheckBox();
		pp.selectStateDropDown();
		pp.selectCityDropDown();
		//pp.openNewTab();
		//pp.handlingTabs();
		//pp.alertsHandling();
		
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		Select sel = new Select(ele);
		sel.selectByVisibleText("");
		sel.selectByValue(null);
		sel.selectByIndex(0);
		
		Set<String> windows=driver.getWindowHandles();
		
		for(String win:windows) {
			String windowTitile = driver.switchTo().window(win).getTitle();
		}
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		driver.switchTo().frame(0);
		WebElement ele1 = driver.findElement(By.xpath(""));
		Actions act = new Actions(driver);
		act.contextClick(ele).build().perform();
		act.doubleClick(ele).perform();
		act.dragAndDrop(ele, ele1).perform();
		act.moveToElement(ele).moveToElement(ele1).perform();
		
		act.sendKeys(Keys.ARROW_DOWN).perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("");
		FileUtils.copyFile(src,dest);
		
		driver.findElement(By.linkText("")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
		
		driver.switchTo().newWindow(WindowType.TAB);  // to open new tab
		
		driver.switchTo().newWindow(WindowType.WINDOW); // open new window
		
	}

}
