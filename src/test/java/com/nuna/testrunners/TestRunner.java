package com.nuna.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/features/",

		
		glue = "com.nuna.steps",

		
		dryRun = false,

		
		tags = "@Smoke",

		monochrome = true, 
		
		plugin = {
				
				"pretty",
				
				"html:htmlreports/cucumber-default-report.html",
				
				"rerun:target/failed.txt"
				
				}

)

public class TestRunner {
	
}
