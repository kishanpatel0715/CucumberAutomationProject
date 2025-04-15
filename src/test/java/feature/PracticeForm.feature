@PracticeForm @NightlyRun
Feature: PracticeForm
  This feature file covers the Form scenarios

  Scenario: TC:123459 Verify Practice Form submission
    When user navigates to the practice form page
    And user enters following details:
      | First Name | Last Name | Email                     | Gender | Mobile     | Subjects   | Hobbies | Picture                                            | Current Address | State   | City    |
      | Kishan     | Patel     | kcpatel07150715@gmail.com | Female | 5879735451 | Automation | Reading | C:\\Users\\kisha\\Pictures\\Screenshots\\Kohli.png | 25 red sky      | Haryana | Panipat |
    And user submits the form
    Then form is submitted successfully
    And following details are displayed
      | First Name | Last Name | Email                     | Gender | Mobile     | Subjects   | Hobbies | Picture   | Current Address | State   | City    |
      | Kishan     | Patel     | kcpatel07150715@gmail.com | Female | 5879735451 | Automation | Reading | Kohli.png | 25 red sky      | Haryana | Panipat |