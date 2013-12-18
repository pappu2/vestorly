Given(/^I filled out with my username and password for enewsletter settings$/) do
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I visit the your settings page for enewsletter settings$/) do
   find("a", text: "Your Settings").click
   find("a", text: "E-newsletter Settings").click
end

Then(/^I should see enewsletter$/) do
  expect(page).to have_content('E-NEWSLETTER SETTINGS')
end

