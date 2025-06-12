@XMLSchema
Feature: XML Schema
  This feature file covers the XML Schema(XSD) related scenarios.

@API @XML
  Scenario:TC178456 Verify XML Schema/XSD for Sum function response 
  	When the user sends a SOAP request to do sum of 12 and 23
    Then the response code is 200
    And the XML Schema is verified successfully  