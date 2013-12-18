When(/^I visit the member login page for your network$/) do
  visit '/mistry'
end

Given(/^I fill out the login form with valid credentials for your network$/) do
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I should see a your network link$/) do
  expect(page).to have_content('Your Network')
  click_on "Your Network"
end

