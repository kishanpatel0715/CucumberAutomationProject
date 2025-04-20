@JSONSchema
Feature: JSON Schema
  This feature file covers the JSON Schema related scenarios.

  Scenario: Verify JSON Schema for comments
    When user sends a request to "http://localhost:3000/comments"
    Then JSON schema validation is completed successfully