@login-feature
  Feature: WebDriver University - Login Page

    Background:
      Given I access the webdriver university login page
      When I enter the username webdriver

    Scenario: Validate Successful Login
      When I enter the password webdriver123
      And I click on the login button
      Then I should be presented with a successful login message

    Scenario: Validate Unsuccessful Login
      When I enter the password password
      And I click on the login button
      Then I should be presented with a unsuccessful login message