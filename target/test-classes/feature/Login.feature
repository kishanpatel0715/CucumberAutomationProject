@Login @NightlyRun
Feature: LogIn
  This feature file covers the login scenarios

  Background: 
    Given User is on the login page

  Scenario: TC:123456 Verify Successful Login with Valid Credentials
    When user enters "standard_user" and "secret_sauce"
    And user login
    Then user is logged-in successfully
    
  Scenario Outline: TC:123457 Verify Login With Invalid Credentials
    When user enters invalid <User_Name> and <Password>
    And user login
    Then Error message is displayed

    Examples: 
      | User_Name | Password |
      | Kishan    | Patel    |
      | CV        | Patel    |

  Scenario: TC:123458 Verify Successful Log-Out
    When user enters "standard_user" and "secret_sauce"
    And user login
    Then user is logged-in successfully
    When user opens side-menu
    And user logout
    Then user is logged-out