Feature: Community feature
  In order to use Vestorly
  As a Your Network|community
  I want to be verify your network
  I want to be verify community page
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data
  Scenario: From view your community
     And I wait for 10 seconds
     Given I am going signed in
	 When I am signed in for community
	 When I should see a your network link for community
	 When I visit the your settings page for community feature
	 Then I visit community link
	 Then I should see a content views
	 
 