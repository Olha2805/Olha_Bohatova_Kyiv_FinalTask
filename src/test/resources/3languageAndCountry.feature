Feature: Language and country
  As a user
  I want to test cart functional in main site
  So that I can be sure that site works correctly

  Scenario Outline: Check that we can change country website to Australia
    Given User opens '<homePage>' page
    When User click to Menu button
    And User select another country
    Then User can click '<name_of_button>' button

    Examples:
      | homePage                 |name_of_button |
      | https://www.amazon.com/  |Go to website  |

  Scenario Outline: Check that cart changing name after change language to Spanish
    Given User opens '<homePage>' page
    When User click to language bar
    And User select another language
    And User click Save Changes button
    Then User checks that cart have name '<newNameOfCart>'

    Examples:
      | homePage                    | newNameOfCart  |
      | https://www.amazon.com/     | Carrito        |
