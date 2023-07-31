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
@register
Feature: Register User
Register user

Background:
Given User is on register page

	@registernormally
	Scenario Outline: Register user normally
	Given User want to register account
	When User typing <firstname> , <lastname> , <email> , <password> , and <gender>
	Then Display Success Message

	Examples:
	| firstname | lastname | email | password | confirmpassword | gender  |
	| Septian | Adi | septian.andika@mail.com | User123! | male |