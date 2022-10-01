@Smoke @GoogleTranslate 
Feature: GoogleTranslate Page Functionality

	Background:
	Given user navigated to the website succesfully
	
	@TranslateFunction
  Scenario: Validating translation between languages works succesfully
    When user selects source language from the menu 
    And selects translation language
    And enters the text in the input field on the left
    Then user validates the translation result on the left is correct
    
   @SwapButtonFunction 
  Scenario: Validating swap languages button function
   	When user selects source language from the menu 
    And selects translation language
    And enters the text in the input field on the left
    When user also clicks on the swap button
    Then user validates the translation result has also been swapped successfully
    
    @ScreenKeyboardFunction
   Scenario: Validating screen keyboard function
   	When user selects source language from the menu 
   	And selects translation language
    And enters the text in the input field on the left
    When user then clears the text from the field
    And selects the screen keyboard and enter a different text
    Then user validates the text is written and translated correctly
   
    
    

  