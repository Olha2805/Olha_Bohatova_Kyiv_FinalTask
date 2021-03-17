Feature: Search
  As a user
  I want to test search functional in main site
  So that I can be sure that site works correctly



    Scenario Outline: Check searching using categories in searching area
      Given User opens '<homePage>' page
      And User checks search field visibility
      When User writes keyword '<keyword>' in search area
      And User select CategoriesName category
      And User clicks search button
      Then User check that url contains '<categoriesName>'

      Examples:
        | homePage                    | keyword | categoriesName |
        | https://www.amazon.com/     | thing   | baby           |


  Scenario Outline: Check that at least one element on page contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User check that at least one element on page contains search word '<keyword>'

    Examples:
      | homePage                    | keyword |
      | https://www.amazon.com/     | iPad    |



  Scenario Outline: Check answer to invalid search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks answer to invalid search word '<answerWord>'

    Examples:
      | homePage                    | keyword       |answerWord    |
      | https://www.amazon.com/     | bhjdzvhjdsddv |No results for|

  Scenario Outline: Check that Amazon Certified area contains word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User click Can works with Alexa filter button
    Then User checks that see word '<word>' on product area

    Examples:
      | homePage                    | keyword | word |
      | https://www.amazon.com/     | Asus    |Alexa |
