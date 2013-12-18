Feature: Build your list feature
  In order to use Vestorly
  As a Your Network|Build your list
  I want to be verify your network
  I want to be added someone in the list
 ----------------------------------------------------------------------------------------------------------------------------------
 
  @needs_login_data
  Scenario: From build your list
     And I wait for 5 seconds
     Given I am going signed in
	 When I am signed in for build your list
	 And I wait for 5 seconds
	 When I should see a your network link for build your list
	 When I visit the your settings page for your network
	 Then I visit build your list link
	 
  @needs_login_data
  Scenario: For list added successfully
     And I wait for 5 seconds
     Given I am going signed in
	 When I am signed in for list
	 And I wait for 5 seconds
	 Then I visit build your list link
     Then I should see add someone individually text
     And I fill out to add someone
     Then I should be added successfully in list
	 
  @needs_login_data
  Scenario: From build your list,LinkedIn SelectAll feature 
     And I wait for 5 seconds
      Given I am going signed in
	 When I am signed in for linkedIn selectall
	 Then I visit build your list link
	 Then I should see selectall link
	 
  @needs_login_data
  Scenario: From build your list,LinkedIn UnselectAll feature 
     And I wait for 5 seconds
	 Given I am going signed in
	 When I am signed in for linkedin unselectall
	 Then I visit build your list link
	 Then I should see unselectall link