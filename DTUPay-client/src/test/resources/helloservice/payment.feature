Feature: Payment
  Scenario: 01 - Successful Payment
    Given a customer with id "cid1"
    And a merchant with id "mid1"
    When the merchant initiates a payment for 10 kr by the customer
    Then the payment is successful

  Scenario: List of transactions
    Given a successful payment of "10" kr from customer "cid1" to merchant "mid1"
    When the manager asks for a list of transactions
    Then the list contains a transaction where customer "cid1" paid "10" kr to merchant "mid1"