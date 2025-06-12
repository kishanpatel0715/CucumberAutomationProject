@API @SOAP
Feature: SOAP
  This feature file covers the SOAP request related scenarios.

@API
  Scenario: TC197123 Verify sum of two numbers through SOAP request
    When the user sends a SOAP request to calculate the sum of 12 and 23
    Then the status code is 200
    And 35 is displayed as the result