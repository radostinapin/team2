@cartfunctionality
Feature:

  Scenario: Navigate and validate card functionality
    When User provides username and password and click login
    Then User validate the  message 'Codefish QA' from homepage
    When User navigates to addcart and cart button and clicks
    When  User navigates  'productName', 'productPrice',  'removeProdBtn'
    When User navigates and click to remove button
    Then  User validates 'Cart is empty.'



