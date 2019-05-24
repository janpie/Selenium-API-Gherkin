

  Scenario: User attempts to cash out more than balance
    Given User has account with 200 pln
     When he attempts to cash out 500 pln
     Then he sees error message
     When he checks if any amount has been cashed out
     Then he sees that no amount has been cashed out

  Scenario: User wants to cash out some mony
    Given User has account with 200 pln
    When User attempts to cash out <amount> pln
    Then he receives proper amount
    And the amount of money left on account is proper

      | amount |
      | 0      |
      | 50     |
      | 100    |
      | 150    |
      | 200    |


