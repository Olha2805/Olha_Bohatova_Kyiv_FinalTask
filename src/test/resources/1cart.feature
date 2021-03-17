Feature: Cart
  As a user
  I want to test cart functional in main site
  So that I can be sure that site works correctly

  Scenario Outline: Check add to cart using search area and menu
    Given User opens '<homePage>' page
    When User click to Menu button
    And User click Electronics button
    And User click Accessories and Supplies button
    And User click add to cart on product
    And User click Home button
    And User makes search by keyword '<keyword>'
    And User click add to cart on product
    And User click Home button
    Then User checks that amount of products in cart are '<amountOfProduct>'

    Examples:
      | homePage                    | keyword     | amountOfProduct |
      | https://www.amazon.com/     | sensory toy | 2               |

  Scenario Outline: Check add to cart using search area
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User click buy now button
    Then User checks that see Sign-in text

    Examples:
      | homePage                    | keyword |
      | https://www.amazon.com/     | acer    |
