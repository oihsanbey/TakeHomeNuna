package com.nuna.steps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nuna.testbase.BaseClass;
import com.nuna.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
	
	@Before
	public void start() throws FileNotFoundException {
		
		BaseClass.setUp();
		

		
	}	

	@After
	public void end(Scenario scenario) {
		
		byte [] picture;
		//add information to the scenario
		
		if (scenario.isFailed()) {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			String destination = Constants.FailedScshotsPath  + scenario.hashCode() + ".png" ;
			
			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			picture = ts.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(picture, "image/png", scenario.getName());
			
		}
		
		else {
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			String destination = Constants.PassedScshotsPath + scenario.hashCode() + ".png" ;
			
			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			picture = ts.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(picture, "image/png", scenario.getName());
		}
		
		BaseClass.tearDown();
		
	}
	
}
