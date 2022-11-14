@smoke
Feature: F07_followUs | users could open followUs links
  Scenario: user opens facebook link
    When user opens facebook link
    Then link is opened in new tab "https://www.facebook.com/nopCommerce"

  Scenario: user opens twitter link
    When user opens twitter link
    Then link is opened in new tab "https://twitter.com/nopCommerce"

  Scenario: user opens rss link
    When user opens rss link
    Then link is opened in new tab "https://demo.nopcommerce.com/news/rss/1"

  Scenario: user opens youtube link
    When user opens youtube link
    Then link is opened in new tab "https://www.youtube.com/user/nopCommerce"
