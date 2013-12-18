Feature: What is vestorly
  In order to use Vestorly
  As a what is it ?
  I want to be able to apply
 ----------------------------------------------------------------------------------------------------------------------------------

  Scenario: From the homepage
    Given I am not signed in
    When I visit the homepage
    Then I should see a What is Vestorly link
	And I wait for 5 seconds

  Scenario: From the What is Vestorly
    Given I am not signed in
    When I visit the What is Vestorly page
    Then I should see a Get Started link
	And I wait for 5 seconds