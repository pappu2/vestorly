Feature: Vestorly Enterprise
  In order to use Vestorly
  As a Vestorly Enterprise 
  I want to be able to apply
 ----------------------------------------------------------------------------------------------------------------------------------

  Scenario: From the homepage
    Given I am not signed in
    When I visit the homepage
    Then I should see a Vestorly Enterprise
	And I wait for 5 seconds
	
  Scenario: From the Vestorly Enterprise
    Given I am not signed in
	And I wait for 5 seconds
    When I visit the Vestorly Enterprise
    Then I should see a Contact Us	
	And I wait for 5 seconds
	