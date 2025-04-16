@DynamicProperties @NightlyRun
Feature: Dynamic_Properties
  This feature file covers the Dynamic Properties scenarios

  Scenario: TC223459 Verify button gets visible after 5 seconds
    When user navigates to the Dynamic Properties page
    Then after 5 seconds, button is visible

  Scenario: TC323459 Verify button gets enabled after 5 seconds
    When user navigates to the Dynamic Properties page
    Then after 5 seconds, button is enabled
