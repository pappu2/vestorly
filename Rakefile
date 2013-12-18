require 'cucumber'
require 'cucumber/rake/task'

Cucumber::Rake::Task.new(:features) do |t|
  t.cucumber_opts = "--format pretty -r support -r features" # Any valid command line option can go here.
end
task :cucumber => [:features]
task default: :features

task :console do
  require 'bundler'
  Bundler.require
  ENV['RACK_ENV']="test"
  Mongoid.load!("config/mongoid.yml")
  require 'irb'
  ARGV.clear
  IRB.start
end
