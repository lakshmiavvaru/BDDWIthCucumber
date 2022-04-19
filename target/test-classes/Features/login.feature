@Regression
Feature: Login functionality of Feature
  
  Scenario: Check Login is successful 
    Given User is on LoginPage
    When user enters Username and Password
    And clicks on login button
    Then user is navigated to Homepage
