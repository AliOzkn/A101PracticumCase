

Feature: A101 Test Automation Practicum

  Scenario: Go to A101 website and test product purchase stages
    Given navigate to A101 website
    When search for socks
    And  choose to buy the first product
    Then check that the product is black
    When go to cart
    And click continue without a member button
    And enter personal details and new address
    And click the complete order button
    Then see go to the payment screen is success
