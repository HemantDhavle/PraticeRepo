Feature: Form filling

Scenario: Validate form filling
Given user is on landing page
When user enters below details
|hemantd17@gmail.com|
|1232323|
|IBM|
|9594595559|
And click on submit
Then details should be submitted successfully