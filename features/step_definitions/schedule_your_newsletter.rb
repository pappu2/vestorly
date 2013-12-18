When(/^I am signed in for schedule your newsletter$/) do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I visit the your content page for newsletter$/) do
 click_on "Your Content"
 click_on "Schedule Your E-Newsletter"
end

Then(/^I should see newsletter content$/) do
  expect(page).to have_content('E-NEWSLETTER SETTINGS')
end

