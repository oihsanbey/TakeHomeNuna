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
				 System.out.println("found");
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
				 System.out.println("found");
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
			Thread.sleep(3000);
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
	
}
