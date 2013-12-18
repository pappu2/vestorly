Feature: Advisor Applies
  In order to use Vestorly
  As an advisor
  I want to be able to apply
 ----------------------------------------------------------------------------------------------------------------------------------

  Scenario: From the homepage
    Given I am not signed in
    When I visit the homepage
    Then I should see an advisor apply link
	And I wait for 10 seconds

  Scenario: Filling out the form
    Given I am not signed in
    When I visit the advisor apply page
    And I fill out the advisor apply form with valid credentials
	And I wait for 10 seconds
    Then I should be thanked for applying
	And I wait for 30 seconds
	
