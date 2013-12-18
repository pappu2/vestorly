Feature: Create original content feature
  In order to use Vestorly
  As a Your Content|Create original content
  I want to be verify original content
  
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data
  Scenario: From original content
     And I wait for 10 seconds
     Given I am going signed in
	 When I am signed in for create original content
	 Then I visit the your content page for create original content
	 Then I should see publish your original content your content
	 