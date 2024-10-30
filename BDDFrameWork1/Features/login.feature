Feature: Login

Scenario Outline: Login Functionality
	Given user navigates to the website saucedemo.com
	And user enter valid "<username>" and "<password>"
	And user click on login Button
	Then login must be successful.
	And close browser
	
Examples:
| username | password |
| standard_user | secret_sauce |
| problem_user | secret_sauce |
