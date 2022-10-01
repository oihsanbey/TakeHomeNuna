package com.nuna.testbase;

import com.nuna.pages.GoogleTranslatePageElements;

public class PageInitializer extends BaseClass {
	
	public static GoogleTranslatePageElements GoogleTranslatePage;

	public static void initialize() {
		GoogleTranslatePage = new GoogleTranslatePageElements();
	}
}
