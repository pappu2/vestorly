When(/^I visit the member login page for your settings$/) do
  visit '/mistry'
end

Then(/^I fill out the login form with valid credentials for your settings$/) do
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I should see a your settings link$/) do
  find("a", text: "Your Settings").click
  visit '/settings'
end

Then(/^I should verify settings page content$/) do
  expect(page).to have_content('ACCOUNT SETTINGS')
end

