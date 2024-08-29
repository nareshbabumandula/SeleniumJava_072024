Feature: Store Search

Background:
Given I access EGW website

@smoke
Scenario: Verify the functionality of searching an eye glass store based on city name
When I want to search for an eyeglass store based on City, State or zipcode
Then So that I can see the store details

@smoke
Scenario: Verify the functionality of searching an eye glass store based on city/state/zipcode name
When I want to search for an eyeglass store based on following search criteria
|tampa|
|florida|
|33629|
Then So that I can see the appropriate store details


@smoke
Scenario Outline: Verify the functionality of searching an eye glass store based on city/state/zipcode name
When I want to search for an eyeglass store based on "<city/state/zipcode>"
Then So that I can see the store details "<city/state/zipcode>"
Examples:
|city/state/zipcode|
|tampa|
|florida|
|33629|

