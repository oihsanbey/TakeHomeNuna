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
	
	@FindBy(xpath="//button[@jsname='dnDxad']")
	public WebElement swapButton;
	
	@FindBy(xpath = "//a[@class='ita-kd-icon-button ita-kd-inputtool-icon ita-kd-small ita-kd-left']")
	public WebElement screenKeyboard;
	
	@FindBy(xpath="//button[@aria-label='Clear source text']")
	public WebElement clearSourceTextButton;
	

public GoogleTranslatePageElements() {
	
	PageFactory.initElements(driver, this);
	
	}

}
