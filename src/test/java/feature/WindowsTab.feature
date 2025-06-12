@WindowsTab @NightlyRun
Feature: WindowsTab
  This feature file covers the login scenarios

  Background: 
    Given the user navigates to DemoQA home page
    And the user selects the Alerts, Frame & Windows from the menu
  	And the user selects Browser Windows from sub-menu  

  Scenario: TC123789 Verify the page opens in a new tab
    When the user clicks the New Tab button
    And the user switches to the newly opened tab
    Then the new tab is displayed with the text "This is a sample page"

  Scenario: TC223789 Verify page is opened up in new window
    When the user clicks the New Window button
    And the user switches to the newly opened window
    Then the new window is displayed with the text "This is a sample page"