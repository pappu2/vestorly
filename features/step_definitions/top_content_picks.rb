When(/^I am signed in for top content feature$/) do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
end

Then(/^I visit the your content page for top content pick$/) do
 click_on "Your Content"
 click_on "Top Content Picks"
end

