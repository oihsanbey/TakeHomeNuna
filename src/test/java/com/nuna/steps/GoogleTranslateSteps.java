package com.nuna.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nuna.testbase.PageInitializer;
import com.nuna.utils.JsonReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GoogleTranslateSteps extends PageInitializer {

	@Given("user navigated to the website succesfully")
	public void user_navigated_to_the_website_succesfully() {
	  driver.get(JsonReader.getJsonProperty("url"));
	}
	@When("user selects source language from the menu")
	public void user_selects_source_language_from_the_menu() {
	    GoogleTranslatePage.DetectLangButton.click();
	    List<WebElement> listLang = driver.findElements(By.xpath("//div[@jsname='Lm8Uhb']"));
		
		 int listLangSize = listLang.size();
		 
		 for (int i = 0; i <listLangSize; i++) {
			 
			 String text = listLang.get(i).getText();
			 
			 if (text.equals(JsonReader.getJsonProperty("sourceLang"))) {
				 listLang.get(i).click();
				 break;
			 }
		 }
	}
	@When("selects translation language")
	public void selects_translation_language() {
	    GoogleTranslatePage.targetLangButton.click();
	    
	    List<WebElement> listLang = driver.findElements(By.xpath("//div[@jsname='Lm8Uhb']"));
		
		 int listLangSize = listLang.size();
	    
	    for (int i = 0; i <listLangSize; i++) {
			 
			 String text = listLang.get(i).getText();
			 
			 if (text.equals(JsonReader.getJsonProperty("translationLang"))) {
				 listLang.get(i).click(); 
				 break;
			 }
	    }
	}
	    

	@When("enters the text in the input field on the left")
	public void enters_the_text_in_the_input_field_on_the_left_and_submit() {
		GoogleTranslatePage.sourceTextArea.click();
		GoogleTranslatePage.sourceTextArea.sendKeys(JsonReader.getJsonProperty("initialText"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("user validates the translation result on the left is correct")
	public void user_validates_the_translation_result_on_the_left_is_correct() {
		String translatedText = GoogleTranslatePage.translatedTextEl.getText();
		Assert.assertEquals(translatedText, JsonReader.getJsonProperty("expectedText"));
	}
	
	@When("user also clicks on the swap button")
	public void user_also_clicks_on_the_swap_button() {
	    GoogleTranslatePage.swapButton.click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("user validates the translation result has also been swapped successfully")
	public void user_validates_the_translation_result_has_also_been_swapped_successfully() {
		 String translatedText = GoogleTranslatePage.translatedTextEl.getText();
		 Assert.assertEquals(translatedText, JsonReader.getJsonProperty("swapExpectedText"));
	}
	
	@When("user then clears the text from the field")
	public void user_then_clears_the_text_from_the_field() {
		GoogleTranslatePage.clearSourceTextButton.click();
	}
	@When("selects the screen keyboard and enter a different text")
	public void selects_the_screen_keyboard_and_enter_a_different_text() {
	    GoogleTranslatePage.screenKeyboard.click();
	}
	@Then("user validates the text is written and translated correctly")
	public void user_validates_the_text_is_written_and_translated_correctly() {
	   List <WebElement> boardKeys = driver.findElements(By.xpath("//button[contains(@class,'vk-btn')]"));
	   String sentKey1 = JsonReader.getJsonProperty("sentKey1");
	   
	   for(WebElement el: boardKeys) {
		   if(el.getText().equalsIgnoreCase(sentKey1)) {
			   el.click();
			   break;
		   }
	   }
	   
	   
	   String sentKey2 = JsonReader.getJsonProperty("sentKey2");
	   
	   for(WebElement el: boardKeys) {
		   if(el.getText().equalsIgnoreCase(sentKey2)) {
			   el.click();
			   break;
		   }
	   }
	   
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	   String expectedTranslation = JsonReader.getJsonProperty("expectedText2");
	   
	   String actualTranslation = GoogleTranslatePage.translatedTextEl.getText();
	   
	   Assert.assertEquals(expectedTranslation,actualTranslation);
	   
	}
	
}
