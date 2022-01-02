package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.ElementsPage_pageObjects;

public class ElementsPage_steps extends BaseClass {
	
	/*@Given("user has launch the browser")
	public void user_has_launch_the_browser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver =  new ChromeDriver();
		EP=new ElementsPage_pageObjects(driver);
	}
	@Given("open the url as {string}")
	public void open_the_url_as(String url) {
		EP=new ElementsPage_pageObjects(driver);
	   driver.get(url);
	}

	@Given("user has clicked on Elements tab")
	public void user_has_clicked_on_elements_tab() {
		EP.clickOnElementTab();
	}
	

	@When("user clicks on Text Box tab")
	public void user_clicks_on_text_box_tab() {
	    EP.clickOntextBoxTab();
	}

	@Then("Text Box page is opened with Full Name, Email, Current Address, Permanent Address text boxes and Submit button")
	public void text_box_page_is_opened_with_full_name_email_current_address_permanent_address_text_boxes_and_submit_button() {
	    EP.enterFullName("Veeranjaneyulu Thota");
	    EP.enterEmail("veeranji141@gmail.com");
	}
	/* @Then("Page title displayed as {string}")
	public void page_title_displayed_as(String title) {
	    
	}*/
	/*
	@Then("close the browser")
	public void close_the_browser() {
		EP.closeBrowser();
	} */
}
