Feature: verify your network feature
  In order to use Vestorly
  As a settings page
  I want to be able to see networks
  
  Scenario: From the your network
    Given I am going signed in
    When I visit the member login page for your network
    Then I fill out the login form with valid credentials for your network
    Then I should see a your network link
	