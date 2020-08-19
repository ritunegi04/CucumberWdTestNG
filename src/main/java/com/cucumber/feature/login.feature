Feature: Test login feature

Scenario Outline: User logs in the application

Given User is on login page
When login page title is displayed
Then User enters "<username>" and "<password>"
Then User is navigated to homepage 
And browser is closed

Examples:

|username|password|
|ritu.negi04@gmail.com | Passutir@20 |
