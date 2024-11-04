Feature: Login

Background:
	Given user navigates to the website https:www.saucedemo.com

Scenario: Login Basic Functionality
	
	And user enter valid "visual_user" and "secret_sauce"
	And user click on login Button
	Then login must be successful.
	And close browser

Scenario Outline: Login Data Driven Functionality

	And user enter valid "<username>" and "<password>"
	And user click on login Button
	Then login must be successful.
	And close browser
	
Examples:
| username | password |
| standard_user | secret_sauce |
| problem_user | secret_sauce |
