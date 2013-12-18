Feature: Scheduled your newsletter feature
  In order to use Vestorly
  As a Your Content|Scheduled your newsletter 
  I want to be verify scheduled your newsletter
  
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data 
  Scenario: From schedule newsletter
     And I wait for 5 seconds
	 Given I am going signed in
	 When I am signed in for schedule your newsletter
	 Then I visit the your content page for newsletter
	 Then I should see newsletter content
	 