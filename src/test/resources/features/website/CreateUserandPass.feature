@regresion
Feature: Testing Account creation and Login Functionality of Codefish QA

  @createUsername
  Scenario: Testing positive login (account creation)
    When  User provides username and password and click register button
    Then User validate the  message 'Codefish QA' from homepage

  @positivelogin
  Scenario:
    When  User provides username and password and click login
    Then User validate the  message 'Codefish QA' from homepage

  @negativelogin
  Scenario Outline:
    When  User provides '<username>' and '<password>' for CodeFish QA
    Then User validate the,'<errorMessage>' error message

    Examples:
      | username | password | errorMessage          |
      | test     | test1234 | Authentication failed |
      | test1    | hahfl    | Authentication failed |
    |    hdgasd      |   ds       |      aad                 |







