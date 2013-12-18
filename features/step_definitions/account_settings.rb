When(/^I am signed in for account settings$/) do
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I visit the your settings page for account settings$/) do
 click_on "Your Settings"
 click_on "Account Settings"
end

Then(/^I should see account settings$/) do
  expect(page).to have_content('ACCOUNT SETTINGS')
end

