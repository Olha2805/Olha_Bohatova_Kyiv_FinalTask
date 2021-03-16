Feature: Amazon Music
  As a user
  I want to test Amazon Music functional in main site
  So that I can be sure that site works correctly

  Scenario Outline: Check that we can try Amazon Music Unlimited free for 30 days
    Given User opens '<homePage>' page
    When User click to Menu button
    And User click Amazon Music button
    And User click Amazon Music Unlimited button
    Then User check that see '<days>' period

    Examples:
      | homePage                    | days |
      | https://www.amazon.com/     | 30   |

    Scenario Outline: Check that we can Open Web Player in Amazon Music
      Given User opens '<homePage>' page
      When User click to Menu button
      And User click Amazon Music button
      And User click Amazon Music Unlimited button
      And User click Open Web Player button
      Then User check that url contains '<stringForCheck>'

      Examples:
        | homePage                    | stringForCheck|
        | https://www.amazon.com/     | music.amazon  |