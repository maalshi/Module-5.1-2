Feature: verify User can see Flight Results page

@smokeTest
Scenario Outline: User performs a Flight search
Given I open https://www.aerlingus.com/html/home.html page
When I perform a Flight search
And press Find Flights button
Then I see Flight Results page
