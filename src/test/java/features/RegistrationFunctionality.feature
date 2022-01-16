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

@Registration @1.0
Feature: Registration Functionality
New user will be able to register to the application.

@EndToEnd @Regression @DataDriven
Scenario Outline: Positive registration functionality test
Given user is in homepage
When user clicks Register link
And user provides all the required details "<FirstName>", "<LastName>", "<Country>", "<Username>", "<Password>" & "<ConfirmPassword>"
And clicks submit button
Then user should be able to register
And user should be able to see successful registration message with provide "<Username>"

Examples:
|FirstName|LastName|Country|Username|Password|ConfirmPassword|
|Tommy|Hank|UNITED STATES|tm12|123|123|
|Marry|Night|AUSTRALIA|mn12|123|123|

@EndToEnd @Regression
Scenario: Positive registration functionality test
Given user is in homepage
When user clicks Register link
And user doesn't provide any required data 
And clicks submit button
Then user should not be able to register
And user should be able to see error message

