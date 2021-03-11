Feature: Smoke
  As a user
  I want to test all mail site functional
  So that I can be sure that site works correctly

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>'
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User click wish list on first product
    Then User checks that amount of products in wish list are '<amountOfProduct>'
    And Check something
    And Check some '<keyword>'

    Examples:
    | homepage                    | keyword | amountOfProducts
    | https://rozetka.com.ua/ua/  | cake    |