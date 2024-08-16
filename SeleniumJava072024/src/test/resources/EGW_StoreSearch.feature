Feature: Store Search

@smoke
Scenario: Verify the functionality of searching an eye glass store based in city name
Given As a customer/patient
When I want to search for an eyeglass store based on City, State or zipcode
Then So that I can see the store details