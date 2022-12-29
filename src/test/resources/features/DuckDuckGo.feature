Feature: Test DuckDuckGo search functionality

    Scenario: As a user I enter a search criteria in DuckDuckGo
        Given I am on the DuckDuckGo search page
        When I enter a search criteria
        And click on the search button
        Then the results match the criteria




