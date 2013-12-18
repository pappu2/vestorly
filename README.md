<<<<<<< HEAD
# Vestorly Acceptance Tests

Blackbox acceptance tests.

## Installing Dependencies

You'll need the right version of Ruby which you can get with `rvm` or `rbenv`.

If you have `rvm` installed, changing into this directory will automatically load the correct Ruby unless you don't have it. Otherwise, it'll give you an `rvm install` command that you can run to install Ruby.

Once you have Ruby installed make sure you have the gem `bundler`

    gem install bundler

Now to install all the required gems:

    bundle install

## Running the Acceptance Tests

To run the tests in your default selenium enabled browser and against the `vestorly-acceptance` staging environment:

    bundle exec rake

## Debugging

To debug a specific step call `save_and_open_page` within the step.

## Project Layout

* `features/*.feature`: cucumber features
* `features/step_definitions/web_steps.rb`: generic steps that apply to all features
* `features/step_definintions/[feature]_steps.rb`: steps specific to an individual feature file
* `support/env.rb`: configures the driver and the hostname to use

## Additional Documentation

* <http://cukes.info> (for general cucumber information)
* <http://github.com/jnicklas/capybara> (for actions such as click_link, click_button, etc...)
=======
vestorly
========

vestorly
>>>>>>> 0d9fc20e4f6e77db77abaf344f1c09d55960a49a
