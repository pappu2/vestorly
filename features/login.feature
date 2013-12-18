Feature: login with valid credentials
  In order to use Vestorly
  As a Home page|Member Login
  I want to be able to login
 ----------------------------------------------------------------------------------------------------------------------------------
 
  Scenario: From the homepage
    Given I am not signed in
    When I visit the member login page
	And I wait for 10 seconds

  @needs_login_data 
  Scenario: From login Page
    Given I am going signed in
    When I visit the member login page
	When I fill out the login form with valid credentials
	Then I clicked on logout link
	