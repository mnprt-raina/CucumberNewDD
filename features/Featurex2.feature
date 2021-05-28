Feature: login action with invalid credentials 

Scenario Outline: login test with invalid credentials
Given The signin page displays
When User clicks on login button
Then User enters <username> in the textbox field
Then User enters <password> in teh password field
Then User clicks on login button

Examples:

| username | password |