@PracticeFormPractice
Feature: Title of your feature
  This feature file covers the practice form related scenarios

  Background: 
    Given user has navigated to Practice Practice Form page

  @runn 	
  Scenario: TC123456: Title of your scenario
    When user user enters following details:
      | Field           | Value                                              |
      | First Name      | KC                                                 |
      | Last Name       | Patel                                              |
      | Email           | kishanpatel0715@gmail.com                          |
      | Gender          | Male                                               |
      | Mobile          | 6981846562                                         |
      | Date Of Birth   | 29 August 1994                                     |
      | Subjects        | English                                            |
      | Hobbies         | Sports                                             |
      | Picture         | C:\\Users\\kisha\\Pictures\\Screenshots\\Kohli.png |
      | Current Address | 51 White Moon Gen SW                               |
      | State           | Rajasthan                                          |
      | City            | Jaipur                                             |
		And user submits e-form 
	  Then e-form is submitted successfully
		#And following details are displayed
		#| Field| Value|
		
  Scenario: TC123457: Title of your scenario
    When user user enters enters following details:
      | First Name  | Last Name | Gender | Mobile     | Date Of Birth | Subjects | Hobbies   | Picture  | Current Address | State   | City       |
      | Nishita     | Patel     | Female | 1981846562 | 1 August 1994 | Biology  | Mothering | Vani.png | Maple           | Gujarat | Vidhyanagr |
      | Jyoti       | Amin      | Female | 2981846562 | 2 August 1994 | History  | Talking   | God.png  | Red Sky         | Alberta | Calgary    |
      | Chandrakant | Leuva     | Male   | 3981846562 | 3 August 1994 | Maths    | Sleeping  | Me.png   | Zanda Chawk     | Guj     | Anand      |
