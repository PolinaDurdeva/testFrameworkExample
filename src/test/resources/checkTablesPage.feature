Feature: Tables page test
  As a user I should be able to sort table by some column in any order


  Scenario Outline: Table is sortable by some column
    Given I open tables page
    Then I see "<column>" of "<table>" is sortable
    Examples:
    | column      | table      |
    | Last Name   | Example 2  |