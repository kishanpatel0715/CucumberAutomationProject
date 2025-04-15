@DownloadUpload @NightlyRun
Feature: DownloadUpload
  This feature file covers the Download and Upload scenarios

  Background: 
    Given User is on the Download and Upload page

  Scenario: Verify Download
    When user downloads the file
    Then file is downloaded successfully
    
  Scenario: Verify Upload
    When user uploads the file
    Then file is uploaded successfully
