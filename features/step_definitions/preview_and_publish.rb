When(/^I am signed in for preview and publish$/) do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I should see a your content link for preview and publish data$/) do
 click_on "Your Content"
 click_on "Preview & Publish"
end

Then(/^I visit the your content page for preview and publish page$/) do
  visit '/curate#'
 end
 
Then(/^I should see preview and publish your content$/) do
  expect(page).to have_content('PREVIEW & PUBLISH YOUR CONTENT')
end

