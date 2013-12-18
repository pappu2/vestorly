When(/^I am signed in for select your content$/) do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I should see a your content link for select your content$/) do
 click_on "Your Content"
end

When(/^I visit the your content page$/) do
  visit '#'
end

Then(/^I visit select your content list link$/) do
  visit '/stream'
 end
 
Then(/^I should see select your content text$/) do
  expect(page).to have_content('SELECT YOUR CONTENT')
end

