package com.nuna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nuna.testbase.BaseClass;

public class GoogleTranslatePageElements extends BaseClass {

	@FindBy(xpath ="//span[@jsname='ksKsZd']")
	public WebElement DetectLangButton;
	
	@FindBy(xpath="//button[@jsname='zumM6d']")
	public WebElement targetLangButton;
	
	@FindBy(xpath="//textarea[@jsname='BJE2fc']") 
	public WebElement sourceTextArea;
	
	@FindBy(xpath="//span[@jsname='W297wb']")
	public WebElement translatedTextEl;
	

public GoogleTranslatePageElements() {
	
	PageFactory.initElements(driver, this);
	
	}

}
