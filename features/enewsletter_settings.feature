Feature: Enewsletter Settings feature
  In order to use Vestorly
  As a Your Settings|enewsletter settings
  I want to be verify enewsletter settings
  
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data 
  Scenario: From enewsletter settings
     And I wait for 5 seconds
	 Given I am going signed in
	 When I am visited with my slug name
	 And I filled out with my username and password for enewsletter settings
	 Then I visit the your settings page for enewsletter settings
	 Then I should see enewsletter
	 