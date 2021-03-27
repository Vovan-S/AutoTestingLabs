Feature: Exercise 1 of Homework 3

  Background:
    Given I'm opened homepage
    And I'm logged as Roman - Jdi1234

  Scenario: assert browser title
    Then Browser title is "Home Page"

  Scenario: assert username
    Then Username is "ROMAN IOVLEV"

  Scenario:
    When I click on service at header
    Then I see 9 header list items
    And  Header list items have proper text

  Scenario:
    When I click on service at left sidebar
    Then I see 9 sidebar list items
    And  Sidebar list items have proper text

  Scenario:
    Given I am on Element Page
    Then I see 4 checkboxes
    And I see 4 radio buttons
    And I see 1 dropdown
    And I see 2 buttons

  Scenario:
    Given I am on Element Page
    Then I see the right sidebar

  Scenario:
    Given I am on Element Page
    Then I see the left sidebar

  Scenario:
    Given I am on Element Page
    When I check "Water, Wind"
    Then "Water, Wind" are checked

  Scenario:
    Given I am on Element Page
    When I check "Water, Wind"
    Then "Water, Wind" is logged as "true, true"

  Scenario:
    Given I am on Element Page
    When I select "Selen" at radios
    Then "Selen" is selected at radios

  Scenario:
    Given I am on Element Page
    When I select "Selen" at radios
    Then "Metal" is logged as "Selen"

  Scenario:
    Given I am on Element Page
    When I select "Yellow" at dropdown
    Then "Yellow" is selected at dropdown

  Scenario:
    Given I am on Element Page
    When I select "Yellow" at dropdown
    Then "Color" is logged as "Yellow"

  Scenario:
    Given I am on Element Page
    When I check "Water, Wind"
    And  I check "Water, Wind"
    Then "Water, Wind" are not checked

  Scenario:
    Given I am on Element Page
    When I check "Water, Wind"
    And  I check "Water, Wind"
    Then "Water, Wind" is logged as "false, false"



