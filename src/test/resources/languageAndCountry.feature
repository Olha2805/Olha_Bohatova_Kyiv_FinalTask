Feature: Language and country
  As a user
  I want to test cart functional in main site
  So that I can be sure that site works correctly


  Scenario Outline: Check that changing country website to Canada will change website to another domain
    Given User opens '<homePage>' page
    When User click to Menu button
    And User select another country
    And User click Go to website button
    Then User checks new URL contains '<domain>'

    Examples:
      | homePage                    | domain  |
      | https://www.amazon.com/     | .com.au |

  Scenario Outline: Check that cart changing name after change language to Spanish
    Given User opens '<homePage>' page
    When User click to language bar
    And User select another language
    And User click Save Changes button
    Then User checks that cart have name '<newNameOfCart>'

    Examples:
      | homePage                    | newNameOfCart  |
      | https://www.amazon.com/     | Carrito        |
