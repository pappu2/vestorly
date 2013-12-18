Then(/^I should see a What is Vestorly link$/) do
  expect(page).to have_link('What is Vestorly?')
end

When(/^I visit the What is Vestorly? page$/) do
  visit '/what'
end

Then(/^I should see a Get Started link$/) do
  expect(page).to have_link('Get Started')
end