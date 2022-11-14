@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    And user enter first name "automation" and last name "tester"
    And user enter date of birth
    And user enter email "samah@yahoo.com" field
    And user fills Password fields "Passw0rd#123" "Passw0rd#123"
    Then user clicks on register button
    And success message is displayed
