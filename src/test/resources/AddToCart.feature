Feature: As a user I want to add an item to my cart and proceed to checkout so that I can complete my transaction

  Scenario: User is on the homepage, adds an item to their cart, and clicks proceed to checkout

    Given I am on on the homepage
    When I click the first item's add to cart
    And I click go to checkout on the popup
    Then I am on the checkout page