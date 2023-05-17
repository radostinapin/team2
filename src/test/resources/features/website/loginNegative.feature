@negativelogin
  Feature: Testing negative login Functionality


    Scenario Outline:
      When  User provides '<username>' and '<password>' for CodeFish QA
      Then User validate the,'<errorMessage>' error message

      Examples:
        | username | password | errorMessage          |
        | test     | test1234 | Authentication failed |
        | test1    | hahfl    | Authentication failed |
