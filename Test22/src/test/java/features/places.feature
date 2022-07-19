Feature: Places API calls

Scenario: To add a place
Given The info about the API baseURI
When The user adds the new place details
Then The post API gets successfull response with status code 200



Scenario: To verify the added place
Given The info about the API baseURI
When The user verifies the newly added place
Then The get API gets successfull response with status code 200
