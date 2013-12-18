Then(/^I should see an advisor apply link$/) do
  expect(page).to have_link('Apply')
end

When(/^I visit the advisor apply page$/) do
  visit '/advisors/new'
end

Given(/^I fill out the advisor apply form with valid credentials$/) do
 
  $value = (0...50).map{ ('a'..'z').to_a[rand(26)] }.join
  fill_in "Your Name", with: "Leeroy Jenkins"
  fill_in "Your Email Address", :with => $value + "@mailinator.com"
  fill_in "Phone Number", with: "1800CASTERS"
  fill_in "Your Firm's Name", with: "Bad Casters LLP"
  fill_in "Website", with: "bad-casters-llp.com"
  click_on "Apply Now"
end

When /I want to take control/i do
  exec "mysqldump -u root --password=* test > #{Rails.root}/support/snapshot.sql"
end

Then(/^I should be thanked for applying$/) do
  expect(page).to have_content('Thank you')
end


