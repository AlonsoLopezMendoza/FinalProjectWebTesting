Feature: As a user, I want to be able to checkout so that I can purchase my selected items.

  Scenario: User is in the summary step and wants to proceed with their purchase
    Given I am on the summary step of the checkout page
    When I click on the proceed to checkout button
    Then I arrive at the sign in step


  Scenario: User is on the sign in step and wants to sign in and proceed with their purchase
  Given I am on the sign in step of the checkout page
  When I enter my account details
  Then I arrive at the address step


  Scenario: User is the address step and wants to proceed with their purchase
    Given I am on the address step of the checkout page
    When I click on the proceed to checkout button
    Then I arrive at the shipping step


  Scenario: User is on the shipping step and wants to proceed with their purchase
    Given I am on the shipping step of the checkout page
    When I click on the proceed to checkout button
    And I click on the agree to terms of service checkbox
    Then I arrive at the payment step
