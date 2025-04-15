@WindowsTab @NightlyRun
Feature: WindowsTab
  This feature file covers the login scenarios

  Background: 
    Given User is on the Browser Windows page

  Scenario: TC123789 Verify page is opened up in new tab
    When user clicks on New Tab button
    And user navigates to the newly opened tab
    Then newly opened tab is displayed with text "This is a sample page"

  Scenario: TC223789 Verify page is opened up in new window
    When user clicks on New Window button
    And user navigates to the newly opened window
    Then newly opened window is displayed with text "This is a sample page"