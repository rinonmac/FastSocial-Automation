@login
Feature: Login Page
  User want to login to Application
  
  Background: 
  Given User is on login page

  @ValidLogin
  Scenario: Can login normally
    Given User has valid user account
    When User is typing valid username and password on login form
    And User click login
    Then Redirect to homepage

    @InvalidLogin
    Scenario Outline: Login with invalid Username and Password
    Given User has invalid user account
    When User is typing invalid <username> and <password> on login form
    And User click login
    Then Display error <message>
    
    Examples:
    | username | password | message |
    | usererror | asdfghjkl | Username atau kata sandi salah |