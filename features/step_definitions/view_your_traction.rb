When(/^I am signed in for view your traction$/) do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I should see a your network link for leads$/) do
 click_on "Your Network"
end

When(/^I visit the your settings page for your traction feature$/) do
  visit '#'
end

Then(/^I should see a activity in your community$/) do
  expect(page).to have_content('ACTIVITY IN YOUR COMMUNITY')
end

