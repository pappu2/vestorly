Feature: View Your Traction feature
  In order to use Vestorly
  As a Your Network|community
  I want to be verify your network
  I want to be verify view your traction
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data
  Scenario: From view your traction
     And I wait for 5 seconds
     Given I am going signed in
	 When I am signed in for view your traction
	 When I should see a your network link for leads
	 When I visit the your settings page for your traction feature
	 Then I visit view your traction link
	 Then I should see a activity in your community
	 
 