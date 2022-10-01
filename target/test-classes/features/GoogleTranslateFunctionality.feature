@GoogleTranslate @Smoke
Feature: GoogleTranslate Functionality

	Background:
	Given user navigated to the website succesfully
	
  Scenario: Validating translation between languages works succesfully
    When user selects source language from the menu 
    And selects translation language
    And enters the text in the input field on the left
    Then user validates the translation result on the left is correct
    
    

  