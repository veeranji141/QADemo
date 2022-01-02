package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.PracticeFormPage_pageObjects;

public class PracticeFormPage_steps extends BaseClass {
	//public PracticeFormPage_pageObjects PracticePage;
	WebDriver driver;
	PracticeFormPage_pageObjects PracticePage;
	@Given("open the url")
	public void open_the_url() {
		BaseClass.intialization();
	}
	@Given("user has entered the first name for first name field")
	public void user_has_entered_the_first_name_for_first_name_field() throws Exception {
		PracticePage = new PracticeFormPage_pageObjects(driver);
		PracticePage.setFirstName(prop.getProperty("fname"));
	}

	@Given("user has entered the last name for last name field")
	public void user_has_entered_the_last_name_for_last_name_field() {
		PracticePage.setlastName(prop.getProperty("lname"));
	}

	@Given("user has entered the email for email field")
	public void user_has_entered_the_email_for_email_field() {
		//String email = randomString()+"@gmail.com";
		//PracticePage.setEmail(email);
	} 

	@Given("user has selected the Gender as Male")
	public void user_has_selected_the_gender_as_male() {
		PracticePage.selectMaleGender();
	}

	@Given("user has enetered the mobile number as {string} for mobile number field")
	public void user_has_enetered_the_mobile_number_as_for_mobile_number_field(String mNumber) {
		PracticePage.setMobileNumber(mNumber);
	}

	@Given("user has entered the subject as {string} for Subjects field")
	public void user_has_entered_the_subject_as_for_subjects_field(String string) {
		
	}

	@Given("user has selected the check box for sports and music fields")
	public void user_has_selected_the_check_box_for_sports_and_music_fields() {
		PracticePage.selectSportsCheckBox();
		PracticePage.selectMusicCheckBox();
	}

	/*@Given("user has entered the Permanent address as {string} for Permanent address field")
	public void user_has_entered_the_permanent_address_as_for_permanent_address_field(String string) {
	   
	} */

	@Given("user has selected the State from State and City Dropdown menu")
	public void user_has_selected_the_state_from_state_and_city_dropdown_menu() throws InterruptedException {
		
		PracticePage.selectStateDropdown();
		
	}

	@Given("user has selected the City from City Dropdown menu")
	public void user_has_selected_the_city_from_city_dropdown_menu() {
	   PracticePage.selectCityDropdown();
	}

	@When("^user clicks on Submit button$")
	public void user_clicks_on_submit_button() {
	    PracticePage.clickOnSubmutBtn();
	}

	/*@Then("Stundent account is created successfully")
	public void stundent_account_is_created_successfully() {
	   
	}

	@Then("a success message is displayed on Practice Page")
	public void a_success_message_is_displayed_on_practice_page() {
	   
	}*/
}
