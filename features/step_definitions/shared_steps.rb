When /^I visit the homepage/ do
  visit '/'
end

When /^I go back$/ do
  page.evaluate_script('window.history.back()')
end

When /^I reload the page$/ do
  visit current_path
end

When /^I reload the page (\d+)? times?$/ do |count|
  count.to_i.times do
    step "I reload the page"
  end
end

When /^I pry$/ do
  binding.pry
end

