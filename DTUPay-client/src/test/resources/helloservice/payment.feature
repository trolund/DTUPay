Feature: Payment

  Scenario: Customer is not known
    Given a customer with id ""
    And a merchant with id 2
    When the merchant initiates a payment for 10 kr by the customer
    Then the payment is not successful
    And an error message is returned saying "customer with id -1 is unknown"

  Scenario: Merchant is not known
    Given a customer with id 0
    And a merchant with id 100000
    When the merchant initiates a payment for 20 kr by the customer
    Then the payment is not successful
    And an error message is returned saying "merchant with id 100000 is unknown"