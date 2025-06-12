@DynamicProperties @NightlyRun
Feature: Dynamic_Properties
  This feature file covers the Dynamic Properties scenarios

Background:
    Given the user navigates to DemoQA home page
    And user selects the Elements from menu
    And user selects Dynamic Properties from sub-menu  
		
  Scenario: TC223459 Verify visibility of the button 
    Then after 5 seconds, button is visible

  Scenario: TC323459 Verify button gets enabled 
    Then after 5 seconds, button is enabled