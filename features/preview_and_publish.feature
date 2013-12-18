Feature: Preview & Publish feature
  In order to use Vestorly
  As a Your Content|Preview & Publish
  I want to be verify preview & publish data
  
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data
  Scenario: From your content
     And I wait for 5 seconds
     Given I am going signed in
	 When I am signed in for preview and publish
	 When I should see a your content link for preview and publish data
	 When I visit the your content page for preview and publish page
	 Then I should see preview and publish your content
	 