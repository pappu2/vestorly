When(/^I visit the member login page$/) do
  visit '/sagar'
end

When /I want to take control/i do
  exec "mysqldump -u root --password=* test > #{Rails.root}/support/snapshot.sql"
end

When(/^I fill out the login form with valid credentials$/) do
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I clicked on logout link$/) do
  find("a", text: "Your Settings").click
  find("a", text: "Logout").click
end

