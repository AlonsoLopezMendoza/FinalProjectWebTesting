Feature: As a user, I want to get order confirmation so that I know my order has been placed.

  Scenario: User has made a bank wire transfer
    Given I am satisfied with what is in my cart
    When I click pay by wire transfer
    And I confirm my wire transfer payment option
    Then I will see the order has been confirmed

#  Scenario: User has made a check transfer
#    Given I am satisfied with what is in my cart
#    When I click pay by check
#    And I confirm my check payment option
#    Then I will see the order has been confirmed
