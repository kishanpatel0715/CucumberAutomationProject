@JSONSchema
Feature: JSON Schema
  This feature file covers the JSON Schema related scenarios.

@API
  Scenario:TC678456 Verify JSON schema for comments
    When the user sends a request to "http://localhost:3000/comments"
    Then the JSON schema validation is completed successfully