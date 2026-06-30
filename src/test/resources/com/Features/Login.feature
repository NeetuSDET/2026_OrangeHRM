@Login
Feature: OrangeHRM Login Module
  As a registered user of OrangeHRM
  I want to log into the application
  So that I can access the HR dashboard and its features

  Background:
    Given user is on the OrangeHRM login page

  @Smoke @PositiveTest
  Scenario: Successful login with valid credentials
    When user enters username "Admin" and password "admin123"
    And user clicks on the login button
    Then user should be navigated to the dashboard page

  @Regression @NegativeTest
  Scenario: Unsuccessful login with invalid credentials
    When user enters username "InvalidUser" and password "WrongPass123"
    And user clicks on the login button
    Then user should see an error message "Invalid credentials"

  @Regression @NegativeTest
  Scenario Outline: Login attempt with missing credentials
    When user enters username "<username>" and password "<password>"
    And user clicks on the login button
    Then user should see required field validation errors

    Examples:
      | username | password |
      |          |          |
      | Admin    |          |
      |          | admin123 |

  @Regression
  Scenario: Forgot password link navigates to reset password page
    When user clicks on the forgot password link
    Then user should be navigated to the reset password page
