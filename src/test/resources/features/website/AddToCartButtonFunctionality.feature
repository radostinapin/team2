@smoke @regression
Feature: Add to cart Button

  Scenario: Testing Add to cart button functionality
    When User provides username and password and click login
    Then User validate the  message 'Codefish QA' from homepage
    And User scrolls down the homepage and clicks Add to cart button
    Then User validate Add to cart button has the check mark on

