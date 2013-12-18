Given(/^I am not signed in$/) do
end

When(/^I am visited with my slug name$/) do
  visit '/mistry'
end

Given(/^I am going signed in$/) do
end

Given /^I wait for (\d+) seconds?$/ do |n|
  sleep(n.to_i)
end

Then(/^I visit build your list link$/) do
  visit '/list'
end

Then(/^I visit community link$/) do
  visit '/e/#/community'
end

Then(/^I visit view your traction link$/) do
  visit '/leads'
end


