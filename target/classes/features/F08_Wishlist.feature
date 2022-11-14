@smoke
Feature: wishlist test
  Background:user could login with valid email and password
    Given user go to login page
    When user login with valid credentials "samah@yahoo.com" and "Passw0rd#123"
    And  user press on login button
    Then user login to the system successfully

  Scenario: user can add products to wishList
    When user add product to wishList
    Then success message will be displayed
    And wishList item quantity will be displayed