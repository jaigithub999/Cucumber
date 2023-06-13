Feature: To validate forgoten password functionality

  Background: 
    Given user launch facebook application

  Scenario Outline: To validate forgoten password using mobile number
    When user click the forgoten account link
    And user enter invalid "<mobilenumber>" and click the search button
    Then user see no results page

    Examples: 
      | mobilenumber |
      |   9489765630 |
      
	Scenario Outline: To validate forgotten password using email
	
		When user click the forgoten account link
  	And user enter invalid "<email>" and click the search button
  	Then user see no results page
  	
  	Examples:
  	|email|
  	|jai@gmail.com|