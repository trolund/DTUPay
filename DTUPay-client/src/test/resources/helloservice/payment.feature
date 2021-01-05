Feature: Payment
  Scenario: 01 - Successful Payment
    Given a customer with id 1
    And a merchant with id 2
    When the merchant initiates a payment for 10 kr by the customer
    Then the payment is successful

  Scenario: List of transactions
    Given a successful payment of 10 kr from customer 1 to merchant 2
    When the manager asks for a list of transactions
    Then the list contains a transaction where customer 1 paid 10 kr to merchant 2