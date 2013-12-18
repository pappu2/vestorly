When(/^I am signed in for community$/)do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
  end

Then(/^I should see a your network link for community$/) do
 click_on "Your Network"
end

When(/^I visit the your settings page for community feature$/) do
  visit '#'
end

Then(/^I should see a content views$/) do
expect(page).to have_content('CONTENT VIEWS')
expect(page).to have_content('SUBSCRIBERS')
end

