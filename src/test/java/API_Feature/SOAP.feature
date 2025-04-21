@API @SOAP
Feature: SOAP
  This feature file covers the SOAP request related scenarios.

@API
  Scenario: TC197123 Verify sum of two numbers using SOAP request
    When user sends a SOAP request to perform sum of two numbers 12 and 23
    Then the status code is 200
    And 35 is displayed as a sum
