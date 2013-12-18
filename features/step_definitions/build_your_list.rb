When(/^I am signed in for build your list$/)do
   visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
  end

When(/^I am signed in for list$/)do
   visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
  end

When(/^I am signed in for linkedIn selectall$/)do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
  end


When(/^I am signed in for linkedin unselectall$/)do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
  end

Then(/^I should see a your network link for build your list$/) do
 click_on "Your Network"
end

When(/^I visit the your settings page for your network$/) do
  visit '#'
end

Then(/^I should see add someone individually text$/) do
  expect(page).to have_content('ADD SOMEONE INDIVIDUALLY')
  expect(page).to have_content('UPLOAD A LIST OF YOUR MEMBERS')
  expect(page).to have_content('BUILD YOUR DISTRIBUTION LIST')
 end

Given(/^I fill out to add someone$/) do
  fill_in "advisor_user_first_name", with: "pappu"
  fill_in "advisor_user_last_name", with: "sagar"
  fill_in "advisor_user_email", with: "pappusagar@gmail.com"
  click_on "Add New Member"
end

Then(/^I should be added successfully in list$/) do
  expect(page).to have_content('User Added Successfully')
end

Then(/^I should see selectall link$/) do
  expect(page).to have_content('Select All')
end

Given(/^I click on selectall link$/) do
  click_on "Select All"
end

Then(/^I should be selected all users from linkedIn$/) do
   expect(page).to have_content('Selected')
end

Then(/^I should see unselectall link$/) do
  click_on "Select All"
end

Then(/^I click on unselectall link$/) do
  click_on "Unselect All"
end

Then(/^I should be unselected all users from linkedIn$/) do
   expect(page).to have_content('Invite')
end