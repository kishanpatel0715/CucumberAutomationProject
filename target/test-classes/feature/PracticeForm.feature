@PracticeForm @NightlyRun
Feature: PracticeForm
  This feature file covers the Form scenarios

	Background:
		Given the user navigates to DemoQA home page
		And the user selects the Forms from menu
		
  Scenario: TC123459 Verify successful Practice Form submission
    When the user selects Practice Form from the sub-menu
    And the user enters following details:
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
    And the user submits the form
    Then the form is submitted successfully
    And the following details are displayed:
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