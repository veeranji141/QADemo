package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage_pageObjects {
	public WebDriver driver;
	public ElementsPage_pageObjects(WebDriver driver1) {
		
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}
	@FindBy(xpath="//li[@id='item-0']") WebElement elementsTab;
	@FindBy(css="#item-0") WebElement textBoxTab;
	@FindBy(xpath="//div[contains(text(),'Text Box')]") WebElement textBoxTitle;
	@FindBy(xpath="//input[@id='userName']") WebElement fullName;
	@FindBy(xpath="//input[@id='userEmail']") WebElement email;
	@FindBy(xpath="//textarea[@id='currentAddress']") WebElement currentAddress;
	@FindBy(xpath="//textarea[@id='permanentAddress']") WebElement permanentAddress;
	
		
	public void clickOnElementTab() {
		elementsTab.click();
	}
	
	public void clickOntextBoxTab() {
		textBoxTab.click();
	}
	public void enterFullName(String fName) {
		fullName.clear();
		fullName.sendKeys(fName);
		
	}
	public void enterEmail(String eMail) {
		email.clear();
		email.sendKeys(eMail);
		
	}
	public void enterCurrentAddress(String currAddress) {
		fullName.clear();
		fullName.sendKeys(currAddress);
		
	}
	public void enterPermanentAddress(String perAddress) {
		fullName.clear();
		fullName.sendKeys(perAddress);
		
	}
	
	public void getPageText() {
		textBoxTitle.getText();
	}
	
	/*public void closeBrowser() {
		driver.quit();
	}*/
		
}
