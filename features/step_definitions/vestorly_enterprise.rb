Then(/^I should see a Vestorly Enterprise$/) do
  expect(page).to have_link('Vestorly Enterprise')
end

When(/^I visit the Vestorly Enterprise$/) do
  visit '/enterprise'
end

Then(/^I should see a Contact Us$/) do
  expect(page).to have_link('Contact Us')
end