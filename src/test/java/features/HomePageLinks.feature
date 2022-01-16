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
@HomePageLinks @Links @2.0
Feature: Home Page links functionality
All home page links need to take customer to right page

@Smoke @Regression
Scenario: Flights link functionality test
Given user is in homepage
When user clicks Flights link
Then user will land into Flight Finder page

@Smoke @Regression
Scenario: Register link functionality test
Given user is in homepage
When user clicks Register link
Then user will land into Register page
