@login-feature
  Feature: WebDriver University - Login Page

    Scenario: Validate Successful Login
      Given I access the webdriver university login page
      When I enter the username webdriver
      And I enter the password webdriver123
      And I click on the login button
      Then I should be presented with a successful login message

    Scenario: Validate Unsuccessful Login
      Given I access the webdriver university login page
      When I enter the username johndoe
      And I enter the password password
      And I click on the login button
      Then I should be presented with a unsuccessful login message