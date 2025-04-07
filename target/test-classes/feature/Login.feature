@Login
Feature: Login Feature

  Background: 
    Given User is on the login page

  @SmokeTest1 @One @Two @JayGanesh
  Scenario: TC15 SSuccessful Login with Valid Credentials
    When User enters "standard_user" or "secret_sauce"
    And Clicks on login button
    Then User should be redirected to the home page

  @SmokeTest2 @Three
  Scenario: TC12 FFailed login with invalid username and password
    When User enters "test" and "test123"
    And Clicks on login button
    Then Error message "Epic sadface: Username and password do not match any user in this service" is displayed" is displayed

  @SmokeTest3 @Example1
  Scenario Outline: Title of your scenario outline
    When User enters <UserName> and <Password>
    And Clicks on login button
    Then User should be redirected to the home page

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | abc           | abc          |

  @Skip
  Scenario: TC100 FFailed login with invalid username and password
