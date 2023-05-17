@regresion
Feature: Testing Account creation of Codefish QA

  @createUsername
  Scenario: Testing positive login (account creation)
    When  User provides username and password and click register button
    Then User validate the  message 'Codefish QA' from homepage







