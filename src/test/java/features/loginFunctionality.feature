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

@Login @1.0
Feature: Login functionality
Customer will be able to login into application using this feature

@EndToEnd @Regression
Scenario: Positive login functionality test
Given user is in home page of the application
When enters valid username
And enters valid password
And clicks submit button
Then user will be logged in
And will be able to see login success message

@EndToEnd @Regression
Scenario: Negative login functionality test using both invalid credentials
Given user is in home page of the application
When enters invalid username
And enters invalid password
And clicks submit button
Then user will not be logged in
And will be seeing login error message

@EndToEnd @Regression
Scenario: Negative login functionality test using invalid username but valid password
Given user is in home page of the application
When enters invalid username
And enters valid password
And clicks submit button
Then user will not be logged in
And will be seeing login error message

@EndToEnd @Regression
Scenario: Negative login functionality test using valid username but invalid password
Given user is in home page of the application
When enters valid username
And enters invalid password
And clicks submit button
Then user will not be logged in
And will be seeing login error message

## Scenario Outline => Data Driven scenarios => Data table will be created using Examples
@EndToEnd @Regression @DataDriven
Scenario Outline: Positive Data driven login functionality test
Given user is in home page of the application
When enters valid username "<username>"
And enters valid password "<password>"
And clicks submit button
Then user will be logged in
And will be able to see login success message

Examples:
|username|password|
|test123|123|
|test|123|
|test12|123|

@EndToEnd @Regression @DataDriven
Scenario Outline: Negative Data driven login functionality test
Given user is in home page of the application
When enters invalid username "<username>"
And enters invalid password "<password>"
And clicks submit button
Then user will not be logged in
And will be seeing login error message

Examples:
|username|password|
|thomas12345|12345|
|johonny1234|12345|
