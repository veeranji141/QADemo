Feature: Verify each and every elements on the page
Scenario: Verify that when user enters the all details on Student Registration Page then Stundent account is created successfully.
Given open the url as "https://demoqa.com/automation-practice-form"
And user has entered the first name as "Veeranjaneyulu" for first name field
And user has entered the last name as "Thota" for last name field
And user has entered the email for email field
And user has selected the Gender as Male
And user has enetered the mobile number as "99999999999" for mobile number field
And user has entered the subject as "Physics" for Subjects field
And user has selected the check box for sports and music fields
And user has selected the State from State and City Dropdown menu
And user has selected the City from City Dropdown menu
When user clicks on Submit button