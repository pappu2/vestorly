Feature: View publish content feature
  In order to use Vestorly
  As a Your Content|View publish content 
  I want to be verify view publish content
  
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data @ignore
  Scenario: From publish content
     And I wait for 5 seconds
	 Given I am going signed in
	 When I am signed in for publish content feature
	 Then I visit the your content page for publish content
	 Then I should see view published content
	 