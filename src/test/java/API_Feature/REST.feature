@API @REST
Feature: API
  This feature file covers the API related scenarios.

@API
  Scenario: TC897123 Verify user details
    Given the user sends a GET request to "https://jsonplaceholder.typicode.com/users/1"
    Then the response status code is 200
    And the response is contained name "Leanne Graham"

@API
  Scenario: TC897124 Verify user comments
    Given the user sends a GET request to "http://localhost:3000/comments"
    Then the response status code is 200
    And the response is contained text "a comment about post 1"
    
@API
  Scenario: TC897125 Verify successful addition of a comment 
    When the user adds a comment
    Then the comment is added successfully

@API
  Scenario: TC897127 Verify successful update of the text
    When the user updates the text
    Then the text is updated successfully

@API
  Scenario: TC897128 Verify successful update of a comment
    When the user updates a comment
    Then the comment is updated successfully

@API
  Scenario: TC897129 Verify successful deletion of a comment
    When the user deletes a comment
    Then the comment is deleted successfully

@API 
  Scenario: TC897323 Verify book details
    Given the user sends a GET request to "https://demoqa.com/BookStore/v1/Books"
    Then the response status code is 200
    And the following book details are displayed:
      | isbn          | title                                     | subTitle                                                          | author               | publish_date             | publisher       | pages | description                                                                                                                                                                                                                                                           | website                                                                 |
      | 9781449325862 | Git Pocket Guide                          | A Working Introduction                                            | Richard E. Silverman | 2020-06-04T08:48:39.000Z | O'Reilly Media  |   234 | This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp       | http://chimera.labs.oreilly.com/books/1230000000561/index.html          |
      | 9781449331818 | Learning JavaScript Design Patterns       | A JavaScript and jQuery Developer's Guide                         | Addy Osmani          | 2020-06-04T09:11:40.000Z | O'Reilly Media  |   254 | With Learning JavaScript Design Patterns, you'll learn how to write beautiful, structured, and maintainable JavaScript by applying classical and modern design patterns to the language. If you want to keep your code efficient, more manageable, and up-to-da       | http://www.addyosmani.com/resources/essentialjsdesignpatterns/book/     |
      | 9781449337711 | Designing Evolvable Web APIs with ASP.NET | Harnessing the Power of the Web                                   | Glenn Block et al.   | 2020-06-04T09:12:43.000Z | O'Reilly Media  |   238 | Design and build Web APIs for a broad range of clients—including browsers and mobile devices—that can adapt to change over time. This practical, hands-on guide takes you through the theory and tools you need to build evolvable HTTP services with Microsoft       | http://chimera.labs.oreilly.com/books/1234000001708/index.html          |
      | 9781449365035 | Speaking JavaScript                       | An In-Depth Guide for Programmers                                 | Axel Rauschmayer     | 2014-02-01T00:00:00.000Z | O'Reilly Media  |   460 | Like it or not, JavaScript is everywhere these days-from browser to server to mobile-and now you, too, need to learn the language or dive deeper than you have. This concise book guides you into and through JavaScript, written by a veteran programmer who o       | http://speakingjs.com/                                                  |
      | 9781491904244 | You Don't Know JS                         | ES6 & Beyond                                                      | Kyle Simpson         | 2015-12-27T00:00:00.000Z | O'Reilly Media  |   278 | No matter how much experience you have with JavaScript, odds are you don’t fully understand the language. As part of the \\"You Don’t Know JS\\" series, this compact guide focuses on new features available in ECMAScript 6 (ES6), the latest version of the st | https://github.com/getify/You-Dont-Know-JS/tree/master/es6%20&%20beyond |
      | 9781491950296 | Programming JavaScript Applications       | Robust Web Architecture with Node, HTML5, and Modern JS Libraries | Eric Elliott         | 2014-07-01T00:00:00.000Z | O'Reilly Media  |   254 | Take advantage of JavaScript's power to build robust web-scale or enterprise applications that are easy to extend and maintain. By applying the design patterns outlined in this practical book, experienced JavaScript developers will learn how to write flex       | http://chimera.labs.oreilly.com/books/1234000000262/index.html          |
      | 9781593275846 | Eloquent JavaScript, Second Edition       | A Modern Introduction to Programming                              | Marijn Haverbeke     | 2014-12-14T00:00:00.000Z | No Starch Press |   472 | JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale        | http://eloquentjavascript.net/                                          |
      | 9781593277574 | Understanding ECMAScript 6                | The Definitive Guide for JavaScript Developers                    | Nicholas C. Zakas    | 2016-09-03T00:00:00.000Z | No Starch Press |   352 | ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that E       | https://leanpub.com/understandinges6/read                               |

@API
 	Scenario: TC897125 Verify successful addition of a post
    When the user adds a post
    Then the post is added successfully
    
@API
  Scenario: TC897127 Verify successful update of a post title
    When the user updates a post title
    Then the post title is updated successfully
   
@API 
  Scenario: TC897128 Verify successful  update of a post 
    When the user updates a post
    Then the post is updated successfully

@API
  Scenario: TC897129 Verify successful deletion of a post
    When the user deletes a post
    Then the post is deleted successfully