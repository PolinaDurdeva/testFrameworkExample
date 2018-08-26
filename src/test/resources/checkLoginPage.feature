Feature: Login page test
  As a user I should be able to log in the secure area


  Scenario: Success login
    Given I open login page
    When I fill in username "tomsmith" and password "SuperSecretPassword!"
    And I click on login button
    Then "You logged into a secure area!" is displayed on the page

  Scenario: Fail login with wrong username
    Given I open login page
    When I fill in username "tomadisson" and password "SuperSecretPassword!"
    And I click on login button
    Then "Your username is invalid!" is displayed on the page

  Scenario: Fail login with wrong password
    Given I open login page
    When I fill in username "tomsmith" and password "SuperSecretPassword"
    And I click on login button
    Then "Your password is invalid!" is displayed on the page
