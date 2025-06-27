@Alerts @NightlyRun
Feature: Alerts
  This feature file covers the Alert scenarios

  Background: 
    Given the user navigates to DemoQA home page
    And the user selects the Alerts, Frame & Windows from the menu
    And the user selects Alerts from the sub-menu

  Scenario: TC423459 Verify alert text and accept behavior
    When the user opens the regular alert
    Then an alert is displayed with the text "You clicked a button"
    When the user accepts the alert
    Then the alert is no longer visible

  Scenario: TC523459 Verify alert text when it appeares after 5 seconds and accept behavior
    When the user opens the delayed alert
    Then delayed alert is displayed with the text "This alert appeared after 5 seconds"
    When the user accepts the alert
    Then the alert is no longer visible

  Scenario: TC623459 Verify cancel action for confirm box
    When the user opens the confirm box
    Then an alert is displayed with the text "Do you confirm action?"
    When the user cancels the alert
    Then the alert is no longer visible
    And "You selected Cancel" message is displayed

  Scenario: TC723459 Verify prompt
    When the user opens the prompt box
    Then an alert is displayed with the text "Please enter your name"
    When the user enters the name "Kishan Patel"
    And the user accepts the alert
    Then "You entered Kishan Patel" message is displayed
