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
@login
Feature: Login Page
  User want to login to Application

  @ValidLogin
  Scenario Outline: Can login normally
    Given User is on login page
    When User is typing <username> and <password> on login form
    And User click login
    Then Redirect to homepage
    
    Examples:
    | username | password |
    | rinonmac | password |
