@smoke
Feature: search feature test
  Scenario Outline: user can search by product name
    When user click on search field
    And user search with "<productName>"
    Then user could find "<productName>" relative results
    Examples:
      |productName  |
    |book         |
    |laptop       |
    |nike         |
