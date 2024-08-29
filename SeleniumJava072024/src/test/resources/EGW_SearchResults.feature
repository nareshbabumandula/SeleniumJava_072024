Feature: Store Search

Background:
Given I access EGW website

@dryrun
Scenario: Verify the display of google maps image in the store search resultspage
When I want to search for an eyeglass store based on City, State or zipcode
Then So that I can see the google map in the search results



