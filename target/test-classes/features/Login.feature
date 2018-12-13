Feature: LoginFeature

Scenario: Valid Login
Given I open browser
And I navigate to the FreeCrm
When I enter valid "SyntaxTechnologies" and "Syntax2017"
And I click login button
Then I successfully logged in


Scenario: Invalid Login
Given I open browser
And I navigate to the FreeCrm
When I enter invalid username and invalid password
And I click login button
Then I see error message
Then I should see error message

Scenario: Invalid Password
Given I open browser
And I navigate to the FreeCrm
When I enter valid username and invalid password
Then I should still see sign up link