#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Create a student
Scenario: Verify that when user enters the all details on Student Registration Page then Stundent account is created successfully.
Given open the url
And user has entered the first name for first name field
And user has entered the last name for last name field
And user has entered the email for email field
And user has selected the Gender as Male
And user has enetered the mobile number for mobile number field
And user has entered the subject as "Physics" for Subjects field
And user has selected the check box for sports and music fields
And user has selected the State from State and City Dropdown menu
And user has selected the City from City Dropdown menu
When user clicks on Submit button


