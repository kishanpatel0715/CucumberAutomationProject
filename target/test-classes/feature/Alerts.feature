@Alerts @NightlyRun
Feature: Alerts
  This feature file covers the Alert scenarios

  Scenario: TC:423459 Verify alert
    When user navigates to the Alerts, Frame & Windows page page
    And user clicks on button to see alert
    Then alert is displayed with text "You clicked a button"
    When user accepts the alert
    Then alert is disappeared
    
  Scenario: TC:523459 Verify alert appeares after 5 seconds
    When user navigates to the Alerts, Frame & Windows page page
    And user clicks on button to see delayed alert
    Then delayed alert is displayed with text "This alert appeared after 5 seconds"
    When user accepts the alert
    Then alert is disappeared

  Scenario: TC:623459 Verify cancel action for confirm box
    When user navigates to the Alerts, Frame & Windows page page
    And user clicks on button to see confirm box
    Then alert is displayed with text "Do you confirm action?"
    When user cancels the alert
    Then alert is disappeared
    And "You selected Cancel" message is displayed

  Scenario: TC:723459 Verify prompt alert
    When user navigates to the Alerts, Frame & Windows page page
    And user clicks on button to see prompt box
    Then alert is displayed with text "Please enter your name"
    When user enters the name "Kishan Patel"
    And user accepts the alert
    Then "You entered Kishan Patel" message is displayed