When(/^I am signed in for publish content feature$/) do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I visit the your content page for publish content$/) do
 click_on "Your Content"
 click_on "View Published Content"
end

Then(/^I should see view published content$/) do
  expect(page).to have_content('Best credit cards')
end

