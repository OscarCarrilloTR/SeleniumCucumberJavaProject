
Feature: Test different actions on a sandbox page.

Scenario: As a QA Engineer, I try out different actions on a sandbox page.
    Given I navigate to the sandobox page
    And select a value form the dropdown


Scenario: As a QA Engineer, I want to retrieve the value of an static table.
    Given I navigate to the static table
    Then I can return the value I wanted


Scenario: As a QA Engineer, I want to validate the static table is displayed.
    Given I navigate to the static table
    Then I can validate the table is displayed


Scenario: As a QA Engineer, I want to validate that a text is present inside the list.
    Given I navigate to the list page
    When I search the list
    Then I can find the text in the list