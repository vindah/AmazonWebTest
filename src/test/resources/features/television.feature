@test
Feature: Amazon feature
  In order to confirm the about of an item
  As a user



    # Amazon home - Checking page loads properly
  @smoke
  Scenario: Verify home page will load properly
    Given The merchant is on the home page
    Then The Logo should be displayed
    Then The search field should be present and editable
    Then The side menu button should be present

    # Amazon television(samsung) - Navigating to page and logging the about
  @acceptance @regression
  Scenario: Verify user can navigate to Samsung television page succeessfully
    Given The merchant is on the home page
    Then The Logo should be displayed
    Then The search field should be present and editable
    Then The side menu button should be present
    When The user clicks on the Side menu button
    And The user clicks on the Tv, Electronics and Appliances text
    And The user clicks on the Television text
    And the user clicks on samsung
    Then The Samsung page should be displayed successfully.
    When The user filters by high to low
    And The user clicks on the second highest item
    Then The user should be able to log the about of the item successfully.