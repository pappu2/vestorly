When(/^I am signed in for create original content$/) do
  visit '/mistry'
  fill_in "username", with: "pappusagar@gmail.com"
  fill_in "password", with: "sagar@perfect"
  click_on "Log in to Your Account"
  end

Then(/^I visit the your content page for create original content$/) do
 click_on "Your Content"
 click_on "Create Original Content"
end

Then(/^I should see publish your original content your content$/) do
  expect(page).to have_content('PUBLISH YOUR ORIGINAL CONTENT')
end

