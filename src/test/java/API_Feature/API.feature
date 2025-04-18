@API
Feature: API
  This feature file covers the API validation scenarios.

  Scenario: TC897123 Verify user details
    Given user sends a GET request to "https://jsonplaceholder.typicode.com/users/1"
    Then the response status code is 200
    And response is contained name "Leanne Graham"
    
  Scenario: TC897124 Verify user comments
    Given user sends a GET request to "http://localhost:3000/comments"
    Then the response status code is 200
    And response content type is "application/json" 
    And response is contained text "a comment about post 1"
    
  Scenario: TC897125 Verify adding a comment 
    When user adds a comment 
    Then comment is added successfully 

  Scenario: TC897127 Verify updating a text 
    When user updates a text 
    Then text is updated successfully 
    
  Scenario: TC897128 Verify updating a comment 
    When user updates a comment 
    Then comment is updated successfully 
      
  Scenario: TC897129 Verify deleting a comment 
    When user deletes a comment 
    Then comment is deleted successfully 