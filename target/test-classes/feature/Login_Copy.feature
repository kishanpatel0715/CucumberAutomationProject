@Logout2
Feature: Login Feature

  @SmokeTest1
  Scenario: TC20 SSuccessful Login with Valid Credentials
    Given User is on the login page
    When User enters "standard_user" or "secret_sauce"
    And Clicks on login button
    Then User should be redirected to the home page

  @SmokeTest2
  Scenario: TC21 FFailed login with invalid username and password
    Given User is on the login page
    When User enters "test" and "test123"
    And Clicks on login button
    Then Error message "Epic sadface: Username and password do not match any user in this service" is displayed" is displayed

  @SmokeTest3 @Example1
  Scenario Outline:TC 22 Title of your scenario outline
    Given User is on the login page
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
