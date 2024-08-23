Feature: Store Search

Background:
Given I access EGW website

@smoke
Scenario: Verify the functionality of searching an eye glass store based in city name
When I want to search for an eyeglass store based on City, State or zipcode
Then So that I can see the store details