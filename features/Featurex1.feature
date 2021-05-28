Feature: login action with valid credentials

Scenario Outline: login test with valid creadentials
Given The Homepage page displays
When User clicks on "Login" button
Then User enters "Username"" in the textbox field from the following <rowid>
Then User enters "Password"" in the textbox field from the following <rowid>
Then User clicks on login button

Examples:
| rowid |

Scenario: logout test
Given The landing page displays
When user clicks on the logout button
Then The signin page displays