Bundler.require unless ENV['USE_RAILS']
require 'bundler'
require 'capybara'
require 'capybara/cucumber'
ENV["CIRCLE_ARTIFACTS"]
if ENV['USE_RAILS']
  require 'cucumber/rails'
  ActionController::Base.allow_rescue = false
  DatabaseCleaner.orm = 'mongoid'
  DatabaseCleaner.strategy = :truncation
  Cucumber::Rails::Database.javascript_strategy = :truncation
  Capybara.configure do |config|
    config.default_driver = :selenium
  end

else
  require 'capybara-screenshot'
  require 'capybara-screenshot/cucumber'

  ENV['RACK_ENV']="test"
  Mongoid.load!("config/mongoid.yml")
  DatabaseCleaner.orm = 'mongoid'
  DatabaseCleaner.strategy = :truncation
  DatabaseCleaner.clean
  Capybara.configure do |config|
    config.default_driver = :selenium
    config.app_host   = 'https://vestorly-dev.herokuapp.com'
  end  
end

if Capybara.current_driver == :selenium
  window = Capybara.current_session.driver.browser.manage.window
  window.resize_to(1500, 800)
end


Before('@needs_login_data') do
  if ENV['USE_RAILS']
    load "#{Rails.root}/blackbox/support/seeds.rb"
  else
    load "support/seeds.rb"
  end  
end 

World(Capybara)

