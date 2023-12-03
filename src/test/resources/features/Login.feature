@login @regression
Feature: WebDriver University - Login Page

  Background:
    Given I access the webdriver university login page

  Scenario Outline: Validate - Successful and Unsuccessful Login
    When I enter the username <username>
    And I enter the password <password>
    And I click on the login button
    Then I should be presented with the following validation message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joe_blogs | password1    | validation failed      |
