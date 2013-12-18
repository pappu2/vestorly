Feature: Archived content feature
  In order to use Vestorly
  As a Your Content|archived content
  I want to be verify archived content
  
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data 
  Scenario: From archived content
     And I wait for 5 seconds
	 Given I am going signed in
	 When I am visited with my slug name
	 And I filled out with my username and password for archived content
	 Then I visit the your content page for archived content
	 Then I should see archived content
	 