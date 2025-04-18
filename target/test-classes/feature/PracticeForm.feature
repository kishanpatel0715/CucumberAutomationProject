@PracticeForm @NightlyRun
Feature: PracticeForm
  This feature file covers the Form scenarios

  Scenario: TC123459 Verify Practice Form submission
    When user navigates to the practice form page
    And user enters following details:
      | First Name      | Kishan                                             |
      | Last Name       | Patel                                              |
      | Email           | kcpatel07150715@gmail.com                          |
      | Gender          | Female                                             |
      | Mobile          | 5879735451                                         |
      | Subjects        | Automation                                         |
      | Hobbies         | Reading                                            |
      | Picture         | C:\\Users\\kisha\\Pictures\\Screenshots\\Kohli.png |
      | Current Address | 25 red sky                                         |
      | State           | Haryana                                            |
      | City            | Panipat                                            |
    And user submits the form
    Then form is submitted successfully
    And following details are displayed
      | First Name      | Kishan                                             |
      | Last Name       | Patel                                              |
      | Email           | kcpatel07150715@gmail.com                          |
      | Gender          | Female                                             |
      | Mobile          | 5879735451                                         |
      | Subjects        | Automation                                         |
      | Hobbies         | Reading                                            |
      | Picture         | Kohli.png                                          |
      | Current Address | 25 red sky                                         |
      | State           | Haryana                                            |
      | City            | Panipat                                            |
    
    
    
      #| First Name | Last Name | Email                     | Gender | Mobile     | Subjects   | Hobbies | Picture   | Current Address | State   | City    |
      #| Kishan     | Patel     | kcpatel07150715@gmail.com | Female | 5879735451 | Automation | Reading | Kohli.png | 25 red sky      | Haryana | Panipat |
