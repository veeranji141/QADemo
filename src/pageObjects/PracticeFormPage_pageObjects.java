package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinitions.BaseClass;


public class PracticeFormPage_pageObjects extends BaseClass {

	public WebDriver driver;
	
	//Initializing page objects
		public PracticeFormPage_pageObjects(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	//Identifying the WebElements using locators
	@FindBy(xpath="//input[@id='firstName']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='lastName']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='userEmail']") WebElement txtEMail;
	@FindBy(xpath="//input[@id='gender-radio-1']") WebElement rdMaleGender;
	@FindBy(id="gender-radio-2") WebElement rdFemaleGender;
	@FindBy(id="userNumber") WebElement txtMobileNumber;
	@FindBy(xpath="//*[@id='subjectsContainer']/div/div[2]") WebElement txtSubjects;
	@FindBy(xpath="//label[contains(text(),'Sports')]") WebElement checkBoxSports;
	@FindBy(xpath="//label[contains(text(),'Reading')]") WebElement checkBoxReading;
	@FindBy(xpath="//label[contains(text(),'Music')]") WebElement checkBoxMusic;
	@FindBy(xpath="//div[contains(text(),'Select State')]") WebElement stateDropdown;
	@FindBy(xpath="//div[contains(text(),'Select City')]") WebElement cityDropdown;
	@FindBy(xpath="//button[@id='submit']") WebElement btnSubmit;

	//Action Methods
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setlastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEMail.sendKeys(email);
	}

	public void selectMaleGender() {
		rdMaleGender.click();
	}
	public void selectFeMaleGender() {
		rdFemaleGender.click();
	}
	public void setSubjects(String subj) {
		txtSubjects.sendKeys(subj);
		
	}
	public void setMobileNumber(String mNumber) {
		txtMobileNumber.sendKeys(mNumber);
	}
	public void selectSportsCheckBox() {
		checkBoxSports.click();
		
	}
	public void selectReadingCheckBox() {
		checkBoxReading.click();
	}
	
	public void selectMusicCheckBox() {
		checkBoxMusic.click();
	}
	
	public void selectStateDropdown() throws InterruptedException {
		WebElement dropdown = stateDropdown;
		Select sel = new Select(dropdown);
		sel.selectByIndex(1);
		Thread.sleep(4000);
	}
	public void selectCityDropdown() {
		WebElement dropdown = stateDropdown;
		Select sel = new Select(dropdown);
		sel.selectByIndex(0);
	}
	
	public void clickOnSubmutBtn() {
		//btnSubmit.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnSubmit);
	}
	
}
