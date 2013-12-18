Feature: verify your settings feature
  In order to use Vestorly
  As a settings page
  I want to be able to see account settings
  
  Scenario: From your settings page
    Given I am going signed in
    When I visit the member login page for your settings
    Then I fill out the login form with valid credentials for your settings
    Then I should see a your settings link
	Then I should verify settings page content
	