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
    | user | password |
