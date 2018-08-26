Feature: Hovers page test
  As a user I should be able to see information when hovering over avatar


  Scenario: Hovers
    Given I open hovers page
    And User info are not displayed
    When I hover over 3 user figures
    Then I see their names under each picture:
      | user1   |
      | user2   |
      | user3   |
