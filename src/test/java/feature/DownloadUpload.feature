@DownloadUpload @NightlyRun
Feature: DownloadUpload
  This feature file covers the Download and Upload scenarios

  Background: 
    Given the user navigates to DemoQA home page
    And user selects the Elements from menu
  	And user selects Upload and Download from sub-menu  

  Scenario: TC912345 Verify successful file download
    When the user downloads the file
    Then the file is downloaded successfully
    
  @test
  Scenario: TC912346 Verify successful file upload
    When the user uploads the file
    Then the file is uploaded successfully