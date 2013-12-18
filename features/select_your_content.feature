Feature: Select your content feature
  In order to use Vestorly
  As a Your Content|Select your content
  I want to be verify your content
  
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data
  Scenario: From your content
  And I wait for 10 seconds
     Given I am going signed in
	 When I am signed in for select your content
	 When I should see a your content link for select your content
	 When I visit the your content page
	 Then I visit select your content list link
	 